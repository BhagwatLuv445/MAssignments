package Exceptions;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CheckDir {

	public static Object checkDir(String dirPath) {

		Object fileName = null;
		boolean valid = true;
		long timeOut = 30;
		try (WatchService service = FileSystems.getDefault().newWatchService()) {
			Map<WatchKey, Path> keyMap = new HashMap<>();
			Path path = Paths.get(dirPath);
			keyMap.put(path.register(service, StandardWatchEventKinds.ENTRY_CREATE), path);
			WatchKey watchkey;
			do {
				watchkey = service.poll(timeOut, TimeUnit.SECONDS);				
				for (WatchEvent event : watchkey.pollEvents()) {
					WatchEvent.Kind kind = event.kind();
					Object name = event.context();
					if (name != null && !name.toString().contains("crdownload")) {												
						fileName = name;
					}
				}
				valid = watchkey.reset();
			} while (valid);

		} catch (Exception e) {

		}
		return fileName;
	}
}
