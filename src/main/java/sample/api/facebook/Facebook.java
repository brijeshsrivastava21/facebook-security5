package sample.api.facebook;

import java.util.List;

import org.springframework.stereotype.Service;

import sample.api.ApiBinding;

@Service
public class Facebook extends ApiBinding {

	private static final String GRAPH_API_BASE_URL = "https://graph.facebook.com/v2.12";

	public Facebook(String accessToken) {
		super(accessToken);
	}
	
	public Profile getProfile() {
		return getRestTemplate().getForObject(GRAPH_API_BASE_URL + "/me", Profile.class);
	}
	
	public List<Post> getFeed() {
		return getRestTemplate().getForObject(GRAPH_API_BASE_URL + "/me/feed", Feed.class).getData();
	}

}
