package com.smartcompute.logging;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.smartcompute.logging.layout.LogLayout;


public class LogMessage {

		
		private int type;
		private Object caller = null;
		private String method = null;
		private String version = null;
		private String messageId = null;
	    private String message = null;
		private Object[] parms = null;

		private boolean legacyLogging = false;

	    /** Single space used as padding separator in the toString() method. */
	    private static final char SINGLE_SPACE_PADDING = ' ';

	    private static final String EMPTY_STRING = "";
	    /** Semicolon, used to show the end of the parameters in the toString() method. */
	    private static final char END_OF_PARMS_IN_TOSTRING = ';';
	    /** End of line character in toString(). */
	    private static final char END_OF_LINE_IN_TOSTRING = '\n';
	    /** Format String used for creating the SimpleDateFormat for the Date in toString(). */
	    private static final String DATE_FORMAT_STRING = "dd-MM-yyyy HH:mm:ss.S";
	    
	    public static final int NORMAL = 1;
	    public static final int HARDCODED = 2;
	    public static final int ENTER = 3;
	    public static final int LEAVE = 4;
		
		private LogMessage(int aType, Object aCaller, String aMethod, String aVersion, String aMessageId, String aMessage, Object[] aParms){
	        type = aType;
			caller = aCaller;
			method = aMethod;
			version = aVersion;
			messageId = aMessageId;
	        message = aMessage;
			parms = aParms;		
		}
		
		private LogMessage(int aType, Object aCaller, String aMethod, String aVersion, String aMessageId, String aMessage, Object[] aParms, boolean oldLogging){
			type = aType;
			caller = aCaller;
			method = aMethod;
			version = aVersion;
			messageId = aMessageId;
			message = aMessage;
			parms = aParms;		
			legacyLogging = oldLogging;
		}
		
		public String toString(){
	        StringBuffer messageBuf = new StringBuffer(150);

	        // Date and time
	        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_STRING);
	        Date dNow = new Date();
	        messageBuf.append(LogLayout.makeLength(sdf.format(dNow), 23));
	        
	        if (caller != null){
	            
	            String className = caller.getClass().getName();
	            
	            if (className.equals(Class.class.getName())){
	                className = ((Class)this.getCaller()).getName();
	            }

	            // Class name
	            messageBuf.append(LogLayout.makeLength(className, 20));
	            
	        }
	        
	        // Version
	        messageBuf.append(this.getVersion());
	        messageBuf.append(SINGLE_SPACE_PADDING);
	        
	        // Thread id
	        messageBuf.append(LogLayout.makeLength(Thread.currentThread().getName(), 30));
	        
	        
	        if (caller != null){
	    
	            Package packageCaller = caller.getClass().getPackage();
	        
	            if (packageCaller != null){
	                // Package name
	                messageBuf.append(LogLayout.makeLength(packageCaller.getName(), 20));
	            } else {
	                messageBuf.append(LogLayout.makeLength(EMPTY_STRING, 20));
	            }
	        } else {
	            messageBuf.append(LogLayout.makeLength(EMPTY_STRING, 20));
	        }
	        
	        // Method name
	        messageBuf.append(this.getMethod());
	        messageBuf.append(SINGLE_SPACE_PADDING);
	        
	        // Logmessage
	        String logMessage = this.getMessageId() + SINGLE_SPACE_PADDING +  this.getMessage();
	        messageBuf.append(logMessage);

	        // Show parameters as well...
	        if ((parms != null) && (parms.length >0)){
	            messageBuf.append(" Parameters: ");
	            for (int i = 0; i < parms.length; i++) {
	                messageBuf.append( ((parms[i]!=null)?(parms[i].getClass().getName()):"null") + SINGLE_SPACE_PADDING + parms[i] + END_OF_PARMS_IN_TOSTRING);
	            }
	        }

	        messageBuf.append(END_OF_LINE_IN_TOSTRING);    
	        
	        return messageBuf.toString();
		}
		
	
		static public LogMessage newMessageInstance(Object aCaller, String aMethod, String aVersion, String aMessageId, Object[] aParms){
			return new LogMessage(NORMAL, aCaller, aMethod, aVersion, aMessageId, null, aParms);
		}
	    

		static public LogMessage newMessageInstance(Object aCaller, String aMethod, String aVersion, String [] messageIdAndText, Object[] aParms) {
			if(messageIdAndText==null || messageIdAndText.length!=2) {
				throw new RuntimeException("Illegal messageId data. Please fix code!");
			}
			return new LogMessage(NORMAL, aCaller, aMethod, aVersion, messageIdAndText[0], messageIdAndText[1], aParms, true);
		}

	    static public LogMessage newHardcodedMessageInstance(Object aCaller, String aMethod, String aVersion, String aMessage, Object[] aParms){
	        return new LogMessage(HARDCODED, aCaller, aMethod, aVersion, null, aMessage, aParms);
	    }
	
	    static public LogMessage newHardcodedMessageInstance(Object aCaller, String aMethod, String aVersion, String aMessage) {
			return new LogMessage(HARDCODED, aCaller, aMethod, aVersion, null, aMessage, null);
	    }
	    
	  
	    static public LogMessage newEnterMessageInstance(Object aCaller, String aMethod, String aVersion, String aMessage, Object[] aParms){
	        return new LogMessage(ENTER, aCaller, aMethod, aVersion, null, aMessage, aParms);
	    }
	    
	   
	    static public LogMessage newLeaveMessageInstance(Object aCaller, String aMethod, String aVersion, String aMessage, Object[] aParms){
	        return new LogMessage(LEAVE, aCaller, aMethod, aVersion, null, aMessage, aParms);
	    }


	    // Getters and setters
		public Object getCaller() {
			return caller;
		}


		public String getMessageId() {
			return messageId;
		}


		public String getMethod() {
			return method;
		}


		public Object[] getParms() {
			return parms;
		}


		public String getVersion() {
			return version;
		}


		public void setCaller(Object object) {
			caller = object;
		}


		public void setMessageId(String string) {
			messageId = string;
		}


		public void setMethod(String string) {
			method = string;
		}


		public void setParms(Object[] objects) {
			parms = objects;
		}


		public void setVersion(String string) {
			version = string;
		}

		public int getType() {
			return type;
		}


		public void setType(int i) {
			type = i;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String string) {
			message = string;
		}

		/**
		 * 
		 * @return
		 */
		public boolean isLegacyLogging() {
			return legacyLogging;
		}

	}


