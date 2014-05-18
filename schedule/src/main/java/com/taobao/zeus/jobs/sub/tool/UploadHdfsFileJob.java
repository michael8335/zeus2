package com.taobao.zeus.jobs.sub.tool;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.taobao.zeus.jobs.AbstractJob;
import com.taobao.zeus.jobs.JobContext;
import com.taobao.zeus.jobs.ProcessJob;
import com.taobao.zeus.model.JobHistory;
import com.taobao.zeus.store.HierarchyProperties;

/**
 * 上传附件到HDFS系统的Job
 * @author zhoufang
 *
 */
public class UploadHdfsFileJob extends ProcessJob{
	
	private String localFilePath;
	private String hdfsPath;
	public UploadHdfsFileJob(JobContext jobContext,
			String localFilePath,
			String hdfsPath) {
		super(jobContext);
		this.localFilePath=localFilePath;
		this.hdfsPath=hdfsPath;
	}

	@Override
	public List<String> getCommandList() {
		List<String> commands=new ArrayList<String>();
//		commands.add("hadoop fs -test -d "+hdfsPath);
//		commands.add("if [ $? == 255 ]; then");
//		commands.add("hadoop fs -mkdir "+hdfsPath);
//		commands.add("fi");
		
		commands.add("/usr/bin/hadoop fs -copyFromLocal "+localFilePath+" "+hdfsPath);
		return commands;
	}
	

}
