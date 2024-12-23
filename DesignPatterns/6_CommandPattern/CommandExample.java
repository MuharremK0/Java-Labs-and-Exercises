package CommandPattern;

public class CommandExample {
	public static void main(String[] args) {
		//Client
		// creating the receiver
		FileSystemReceiver fs = FileSystemReceiverUtil.getUnderlyingFileSystem();
		
		// create the command with the associating receiver
		OpenFileCommand openFileCommand = new OpenFileCommand(fs);
		
		// creating invoker and associate it with the command
		FileInvoker file = new FileInvoker(openFileCommand);
		
		// perform action on invoker object
		file.execute();
		
		
		WriteFileCommand writeFileCommand = new WriteFileCommand(fs);
		file = new FileInvoker(writeFileCommand);
		file.execute();
		
		CloseFileCommand closeFileCommand = new CloseFileCommand(fs);
		file = new FileInvoker(closeFileCommand);
		file.execute();
	}
}


// Receiver Part

interface FileSystemReceiver{
	void openFile();
	void writeFile();
	void closeFile();
}

class UnixFileSystemReceiver implements FileSystemReceiver{

	@Override
	public void openFile() {
		System.out.println("Opening file in unix OS");
		
	}

	@Override
	public void writeFile() {
		System.out.println("Writing file in unix OS");
	}

	@Override
	public void closeFile() {
		System.out.println("Closing file in unix OS");
	}
	
}

class WindowsFileSystemReceiver implements FileSystemReceiver{

	@Override
	public void openFile() {
		System.out.println("Opening file in Windows OS");
		
	}

	@Override
	public void writeFile() {
		System.out.println("Writing file in Windows OS");
	}

	@Override
	public void closeFile() {
		System.out.println("Closing file in Windows OS");
	}
	
}