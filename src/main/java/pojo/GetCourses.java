package pojo;

public class GetCourses {
	
	private String url;
	private String instructor;
	private String linkedIn;
	private String services;
	private String expertise;
	private Courses courses;
	
	public String getUrl() {
		return url;
	}
	public String getInstructor() {
		return instructor;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public String getServices() {
		return services;
	}
	public String getExpertise() {
		return expertise;
	}
	public Courses getCourses() {
		return courses;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public void setCourses(Courses courses) {
		this.courses = courses;
	}
	
	
	
	
}
