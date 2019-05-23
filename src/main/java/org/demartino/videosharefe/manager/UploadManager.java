package org.demartino.videosharefe.manager;

import java.util.List;

import org.demartino.videosharefe.view.Upload;

public interface UploadManager {
	Upload createVideo(Upload upload, String username);
	boolean deleteVideoById(Long id);
	Upload findVideoByTitle(String title);
	Upload updateVideo(Upload upload, String username);
	List<Upload> getAllVideosForUser(String username);
}
