
import java.io.*;
import java.util.ArrayList;

public class ClearHiddenSVNFiles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if (args.length < 1) {
			System.out.println("Bad input! Please input the parent fileDir! ");
			return;
		}
		parentDir = args[0];
		doFind(new File(parentDir));
		deleteHiddens();
	}
	
	private static int doDeleteFiles(File file) {
		if (file.isDirectory()) {
			File [] files = file.listFiles();
			for (int i=0; i<files.length; i++) {
				doDeleteFiles(files[i]);
			}
		}
		file.delete();
		return 0;
	}
	
	private static void deleteHiddens() {
		
		System.out.println("\n*************************************\n");
		int length = hiddenDirs.size();
		for (int i=0; i<length; i++) {
			System.out.println(hiddenDirs.get(i));
			File file = new File((String) hiddenDirs.get(i));
			if (file.exists()) {
				// System.out.print("\t" + file.delete() + "\n");
				doDeleteFiles(file);
			}
		}
	}
	
	private static int doFind(File file) {
		if (file.isHidden()) {
			// 当前文件 目录/文件 为隐藏文件
			if (HIDDEN_SUFFIX.equalsIgnoreCase(file.getName())) {
				hiddenDirs.add(file.getAbsolutePath());
			}
			System.out.println("The Hidden filePath : " + file.getPath());
			return 0;
		} else if (file.isDirectory()) {
			
			File [] dirs = file.listFiles();
			
			if (dirs.length > 0) {
				for (int i=0; i<dirs.length; i++) {
					// System.out.println("dirs: " + dirs);
					doFind(dirs[i]);
				}
			}
		}
		return -1; // 没有找到隐藏文件
	}
	
	private static String parentDir = "~/tmp";
	
	private static ArrayList hiddenDirs;
	
	private static final String HIDDEN_SUFFIX = ".svn";
	
	static {
		if (hiddenDirs == null) {
			hiddenDirs = new ArrayList();
		}
	}
}
