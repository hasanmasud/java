package com.smartcompute.logging.layout;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import com.smartcompute.logging.CMSVersion;
import com.smartcompute.logging.LogMessage;
public class LogLayout extends Layout{
	
    //  String of 60 spaces, for appending fields
    private static final String appendString = "                                                                                          ";
	/** The log message cache */
	private static Hashtable messageCache = new Hashtable();
	/** The log message cache */
	private static Hashtable packageNameCache = new Hashtable();

    private static final String YEAR = "yyyy";
    private static final String MONTH = "MM";
    private static final String DAY = "dd";
    private static final String HOUR = "HH";
    private static final String MINUTE = "mm";
    private static final String SECOND = "ss";
    private static final String MILLISECOND = "SSS";

	private static final String INTERFACES = ".interfaces";

	/** set development debug mode */
	protected static final boolean DEV_DEBUG = false;
    
    /**
     * This method appends spaces to a string. The length of the returned
     * string is given by the parameter length. If a string is longer than 
     * length, the begin of the string is ommited and replaced by ..
     * 
     * @param logMessage The string to append
     * @param length The desired length
     * @return The string with the desired length.
     */
	public static String makeLength(String logMessage, int length){
		int messageLength;
		String message = logMessage;
		StringBuffer outString = new StringBuffer(length);
		
		if(message == null) {
			message = "NULL";
		}		
		messageLength = message.length();
        
        
		// Check the length of a string.
		if (messageLength > length){
			// The string is to long, add .. before the string and make it
			// the desired length.
			outString.append("..");
			outString.append(message.substring(messageLength - length + 2));
			outString.append(" ");
		} else {
			// The string is to short, append space to the desired length.
			outString.append(message);
			outString.append(appendString.substring(0, length - messageLength + 1 ));
		}
            
		// Return the string.
		return outString.toString();
        
	}

	/**
	 *  * Tries to get the message from the cache. When the message is not found in the cache, get it from the 
	 * log-messages.properties and put it in the cache. 
	 * @param logMessage
	 * @return
	 */
	protected final MessageFormat getItemFromCache(final LogMessage logMessage) {

		String messageId = logMessage.getMessageId();
		if(messageId == null) {
			System.err.println("ERROR: Invalid log message id: null");
			messageId = "NULL";
		}

		//Get item from cache
		MessageFormat item = (MessageFormat) messageCache.get(messageId);

		if (item == null) {
			// Item was not in cache.
			// If we are in legacy logging then just use the provided messages
			if (logMessage.isLegacyLogging()) {
				if(logMessage.getMessage() != null) {
					try {
						MessageFormat messageCacheItem = new MessageFormat(logMessage.getMessage());
						messageCache.put(messageId, messageCacheItem);
					} catch(IllegalArgumentException illegalArg) {
						illegalArg.printStackTrace();
						messageCache.put(messageId, "Invalid log message.");
					}
				}
			} else {
				if (DEV_DEBUG) {
					System.out.println("DEBUG: Lookup " + messageId + " in resourcebundle");
				}
				String message = getMessageFromResourceBundle(logMessage.getCaller(), messageId);
                if(message != null) {
					// Put the message into the cache.
					try {	
						MessageFormat messageCacheItem = new MessageFormat(message);
						messageCache.put(messageId, messageCacheItem);
					} catch(IllegalArgumentException illegalArg) {
						illegalArg.printStackTrace();
						messageCache.put(messageId, "Invalid log message.");
					}
                }
			}
			// Get the item from the cache.
			item = (MessageFormat) messageCache.get(messageId);
		} 

		return item;
	}

	/**
	 * Gets the message from a resource bundle.
	 * @param caller The class logging a message
	 * @param messageId The messageId to lookup in the resource bundle
	 * @return The string retreived from the log message resource bundle
	 */
	private final String getMessageFromResourceBundle(final Object caller, final String messageId) {
		String message = null;
		String packageStr = null;
		Package packageCaller = null;

		// Check if caller is not null.
		if (caller != null) {

			// Caller was not null, so get classname of caller.
			String className = caller.getClass().getName();
			// Get the right package name if we are called in a static method.
			if (className.equals(Class.class.getName())) {
				packageCaller = ((Class) caller).getPackage();
			} else {
				packageCaller = caller.getClass().getPackage();
			}

			// Look if we have the right package string in the cache.
			String cachedPackageStr = (String) packageNameCache.get(packageCaller.getName());
			if (cachedPackageStr != null) {
				try {
					ResourceBundle bundle = getResourceBundle(cachedPackageStr + "." + LayoutConstants.LOG_RESOURCEBUNDLE_NAME);
					message = bundle.getString(messageId);
				} catch (MissingResourceException missingExc) {
					//Can happen. Message comes from super or subclass.
				}
			}

			packageStr = packageCaller.getName();
			Class superclass = caller.getClass().getSuperclass();
			/*
			 * Loop thru the package of the class to find the log-messages.properties file.
			 * Also search in the package structure of the super class.
			 */
			while ((message == null) && (superclass != null)) {
				boolean checkInterface = true;
				while (message == null) {
					try {
						PropertyResourceBundle bundle = getResourceBundle(packageStr + "." + LayoutConstants.LOG_RESOURCEBUNDLE_NAME);
						message = bundle.getString(messageId);

						packageNameCache.put(packageCaller.getName(), packageStr);
					} catch (MissingResourceException missingExc) {
						if (packageStr.indexOf(".") != -1) {
							packageStr = packageStr.substring(0, packageStr.lastIndexOf("."));
							if (checkInterface) {
								checkInterface = false;
								packageStr += INTERFACES;
							}
						} else {
							break;
						}
					}
				}
				packageStr = superclass.getPackage().getName();
				if (!packageStr.startsWith(LayoutConstants.DEFAULT_PARAM_AABPACKAGE)) {
					superclass = null;
				} else {
					superclass = superclass.getSuperclass();
				}
			}

		}

		if (message == null) {
			message = messageId;
			if (DEV_DEBUG) {
				System.err.println("INFO: Could not find log message for message-id: " + messageId);
			}
		}

		return message;
	}

	/**
	 * This method returns a PropertyResourceBundle. It locates the property file using the 
	 * classloader of the current thread.
	 * 
	 * @param name
	 * @return
	 * @throws MissingResourceException
	 */
	private final PropertyResourceBundle getResourceBundle(final String name) throws MissingResourceException {
		PropertyResourceBundle bundle;
		String filename = name.replace('.', '/') + ".properties";

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream stream = loader.getResourceAsStream(filename);

		if (stream != null) {
			try {
				bundle = new PropertyResourceBundle(stream);
				return bundle;
			} catch (IOException ioException) {
				ioException.printStackTrace();
			} finally {
				if (stream != null) {
					try {
						stream.close();
					} catch (IOException ioException) {
						ioException.printStackTrace();
					}
				}
			}
		}

		throw new MissingResourceException("", name, "");
	}    

	/**
	 * This method inserts the parameters in to the placeholders of a message.
	 * 
	 * @param formatter A MessageFormat object containing the log message with the placeholders.
	 * @param parms The parameters to insert into the message.
	 * @return
	 */
	protected final String fillPlaceHolders(final MessageFormat formatter, final Object[] parms) {
        String returnString = "";
		if (formatter != null) {
			try {
				returnString = formatter.format(parms);
			} catch(IllegalArgumentException illegalArg) {
				illegalArg.printStackTrace();
			}
		}

		return returnString;
	}

    /**
     * Returns the current date formatted according to the dateFormat string.
     * 
	 * @param dateFormat
	 * @return
	 */
	protected final String getDateString(final String dateFormat) {
        Calendar calendar = Calendar.getInstance();
        StringBuffer buffer = new StringBuffer(dateFormat);

        if(dateFormat != null) {
            String yearStr = String.valueOf(calendar.get(Calendar.YEAR));
            String monthStr = getTwoDigitValue(calendar.get(Calendar.MONTH)+1);
            String dayStr = getTwoDigitValue(calendar.get(Calendar.DAY_OF_MONTH));
            String hourStr = getTwoDigitValue(calendar.get(Calendar.HOUR_OF_DAY));
            String minStr = getTwoDigitValue(calendar.get(Calendar.MINUTE));
            String secStr = getTwoDigitValue(calendar.get(Calendar.SECOND));
            String msecStr = getThreeDigitValue(calendar.get(Calendar.MILLISECOND));
            
            int start, end;

            start = dateFormat.indexOf(YEAR);
            end = start + YEAR.length();
            buffer.replace(start, end, yearStr);
            start = dateFormat.indexOf(MONTH);
            end = start + MONTH.length();
            buffer.replace(start, end, monthStr);
            start = dateFormat.indexOf(DAY);
            end = start + DAY.length();
            buffer.replace(start, end, dayStr);
            start = dateFormat.indexOf(HOUR);
            end = start + HOUR.length();
            buffer.replace(start, end, hourStr);
            start = dateFormat.indexOf(MINUTE);
            end = start + MINUTE.length();
            buffer.replace(start, end, minStr);
            start = dateFormat.indexOf(SECOND);
            end = start + SECOND.length();
            buffer.replace(start, end, secStr);
            start = dateFormat.indexOf(MILLISECOND);
            if(start > -1) {
                end = start + MILLISECOND.length();
                buffer.replace(start, end, msecStr);
            }
        }
        
        return buffer.toString();
    }
    
    /**
	 * @param number
	 * @return
	 */
	private String getTwoDigitValue(int number) {
        String returnString;
        
        if(number < 10) {
            returnString = "0" + String.valueOf(number);
        } else {
            returnString = String.valueOf(number);
        }
        
        return returnString;
    }

    /**
     * @param number
     * @return
     */
    private String getThreeDigitValue(int number) {
        String returnString;
        
        if(number < 10) {
            returnString = "00" + String.valueOf(number);
        } else if(number < 100){
            returnString = "0" + String.valueOf(number);
        } else {
            returnString = String.valueOf(number);
        }
        
        return returnString;
    }
    
    /**
     * No need to provide an implementation for this method.
     * @see org.apache.log4j.Layout#activateOptions()
     */
    public void activateOptions() {
        
    }

	@Override
	public String format(LoggingEvent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ignoresThrowable() {
		// TODO Auto-generated method stub
		return false;
	}
    


}
