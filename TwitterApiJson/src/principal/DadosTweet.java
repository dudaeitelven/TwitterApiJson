package principal;

public class DadosTweet {
	
	private String id_user;
	private String name;
	private String screen_name;
	private String followers_count;
	private String friends_count;
	private String id_tweet;
	private String text;
	private String hashtag;
	private String user_mentions;
	private String elo;
	private int idTweet;
	private int idUser;
	
	
	
	public DadosTweet(String id_user, String name, String screen_name, String followers_count, String friends_count,
			String id_tweet, String text, String hashtag, String user_mentions,String elo, int idUser, int idTweet) {
		super();
		this.id_user = id_user;
		this.name = name;
		this.screen_name = screen_name;
		this.followers_count = followers_count;
		this.friends_count = friends_count;
		this.id_tweet = id_tweet;
		this.text = text;
		this.hashtag = hashtag;
		this.user_mentions = user_mentions;
		this.elo = elo;
		this.idUser = idUser;
		this.idTweet = idTweet;
	
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


	public String getScreen_name() {
		return screen_name;
	}


	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
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


	public String getHastag() {
		return hashtag;
	}


	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}


	public String getUser_mentions() {
		return user_mentions;
	}


	public void setUser_mentions(String user_mentions) {
		this.user_mentions = user_mentions;
	}
	
	public String getElo() {
		return elo;
	}


	public void setElo(String elo) {
		this.elo = elo;
	}


	public int getIdTweet() {
		return idTweet;
	}


	public void setIdTweet(int idTweet) {
		this.idTweet = idTweet;
	}


	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	
	
	
}
