package principal;

public class DadosTweet {
	
	private String id_user;
	private String name;
	private String followers_count;
	private String friends_count;
	private String id_tweet;
	private String text;
	private String data;
	private String elo;
	private long idTweet;
	private long idUser;
	
	
	
	public DadosTweet(String id_user, String name, String followers_count, String friends_count,
			String id_tweet, String data, String text,  String elo, long idUser, long idTweet) {
		super();
		this.id_user = id_user;
		this.name = name;
		this.followers_count = followers_count;
		this.friends_count = friends_count;
		this.id_tweet = id_tweet;
		this.data = data;
		this.text = text;
		this.elo = elo;
		this.idUser = idUser;
		this.idTweet = idTweet;	
	}
	
	public DadosTweet() {
		
	}


	public String getId_user() {
		return id_user;
	}


	public void setId_user(String id_user) {
		this.id_user = id_user;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getFollowers_count() {
		return followers_count;
	}


	public void setFollowers_count(String followers_count) {
		this.followers_count = followers_count;
	}


	public String getFriends_count() {
		return friends_count;
	}


	public void setFriends_count(String friends_count) {
		this.friends_count = friends_count;
	}


	public String getId_tweet() {
		return id_tweet;
	}


	public void setId_tweet(String id_tweet) {
		this.id_tweet = id_tweet;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}
	
	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}

	
	public String getElo() {
		return elo;
	}


	public void setElo(String elo) {
		this.elo = elo;
	}


	public long getIdTweet() {
		return idTweet;
	}


	public void setIdTweet(long idTweet) {
		this.idTweet = idTweet;
	}


	public long getIdUser() {
		return idUser;
	}


	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	
	
}
