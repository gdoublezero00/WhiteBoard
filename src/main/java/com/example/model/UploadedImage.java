package com.example.model;

public class UploadedImage {
	private String path;

	public UploadedImage() {
	}
	public UploadedImage(String path) {
		super();
		this.path = path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return this.path;
	}
}

