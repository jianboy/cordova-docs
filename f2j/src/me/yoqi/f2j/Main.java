package me.yoqi.f2j;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

import com.github.houbb.opencc4j.util.ZhConverterUtil;

/**
 * 繁体字（Traditional Chinese）批量转换为简体字（Simplifiled Chinese）
 * 
 * @author liuyuqi
 *
 */
public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		String srcDirPath = "/home/twtech/workspace/cordova-docs/www/docs/zh-cn";
		String SimpleChineseDirPath = "/home/twtech/workspace/cordova-docs/www/docs/zh-cn-res";

		// 获取所有md文件
		Collection<File> subFile = FileUtils.listFiles(new File(srcDirPath), new String[] { "md" }, true);

		for (File file : subFile) {
			String SimpleChineseFilePath = SimpleChineseDirPath + file.getAbsolutePath().substring(srcDirPath.length());
			FileUtils.writeStringToFile(new File(SimpleChineseFilePath),
					ZhConverterUtil.convertToSimple(FileUtils.readFileToString(file)), "UTF-8");
		}
	}
}
