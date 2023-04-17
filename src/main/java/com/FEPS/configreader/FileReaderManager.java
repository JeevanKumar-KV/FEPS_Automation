package com.FEPS.configreader;



/**
 * Author : JeevanKumar K V
 * Email id  : jeevankumar.kv@conduent.com
 */

public class FileReaderManager {

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static PropertyFileReader configFileReader;

	private FileReaderManager() {
	}

	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}

	public PropertyFileReader getConfigReader()  {
		return (configFileReader == null) ? new PropertyFileReader() : configFileReader;
	}
}