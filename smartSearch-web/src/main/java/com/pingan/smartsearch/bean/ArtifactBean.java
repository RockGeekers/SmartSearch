package com.pingan.smartsearch.bean;

public class ArtifactBean {

	private String groupId;
	
	private String version;
	
	private String artifactId;
	
	public ArtifactBean() {}
	
	public ArtifactBean(String groupId, String version, String artifactId) {
		this.groupId = groupId;
		this.version = version;
		this.artifactId = artifactId;
	}
	
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}
}
