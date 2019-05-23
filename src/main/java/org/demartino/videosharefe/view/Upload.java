package org.demartino.videosharefe.view;


import org.springframework.web.multipart.MultipartFile;

public class Upload {
	private Long id;
	private String title;
	private MultipartFile video;
	
	
	public Upload() {};
	
	public Upload(Long id, String title, MultipartFile video) {
		super();
		this.id = id;
		this.title = title;
		this.video = video;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MultipartFile getVideo() {
		return video;
	}
	public void setVideo(MultipartFile video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return "Upload [id=" + id + ", title=" + title + ", video=" + video + "]";
	}
	
	
}

