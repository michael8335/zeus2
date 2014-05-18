package com.taobao.zeus.jobs.sub.tool;

import java.util.ArrayList;
import java.util.List;

import com.taobao.zeus.jobs.JobContext;
import com.taobao.zeus.jobs.ProcessJob;

/**
 * 从HDFS文件系统下载到本地文件系统
 * 
 * @author zhoufang
 * 
 */
public class DownloadHdfsFileJob extends ProcessJob {

	private String hdfsFilePath;
	private String localPath;

	public DownloadHdfsFileJob(final JobContext jobContext, final String localPath,
			final String hdfsFilePath) {
		super(jobContext);
		this.localPath = localPath;
		this.hdfsFilePath = hdfsFilePath;

	}
	
	@Override
	public List<String> getCommandList() {
		List<String> commands = new ArrayList<String>();
		commands.add("hadoop fs -copyToLocal " + hdfsFilePath + " " + localPath);
		return commands;
	}

}
