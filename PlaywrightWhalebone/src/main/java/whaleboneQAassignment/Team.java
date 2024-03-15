package whaleboneQAassignment;

public class Team {

	private String name;
	private String location;
	private int founded;
	private int firstYearOfPlay;
	private Division division;
	private String officialSiteUrl;

	public Team(String name, String location, int founded, int firstYearOfPlay, Division division,
			String officialSiteUrl) {
		super();
		this.name = name;
		this.location = location;
		this.founded = founded;
		this.firstYearOfPlay = firstYearOfPlay;
		this.division = division;
		this.officialSiteUrl = officialSiteUrl;
	}

	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getFounded() {
		return founded;
	}

	public void setFounded(int founded) {
		this.founded = founded;
	}

	public int getFirstYearOfPlay() {
		return firstYearOfPlay;
	}

	public void setFirstYearOfPlay(int firstYearOfPlay) {
		this.firstYearOfPlay = firstYearOfPlay;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public String getOfficialSiteUrl() {
		return officialSiteUrl;
	}

	public void setOfficialSiteUrl(String officialSiteUrl) {
		this.officialSiteUrl = officialSiteUrl;
	}

}