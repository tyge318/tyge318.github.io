public class Twitter {
    /** Initialize your data structure here. */
    class Tweet {
        int timeId, tweetId;
        public Tweet(int timeId, int tweetId) {
            this.timeId = timeId;
            this.tweetId = tweetId;
        }
    }
    int timeStamp;
    Map<Integer, List<Tweet>> userTimeline;
    Map<Integer, Set<Integer>> userFollows;
    public Twitter() {
        userTimeline = new HashMap<Integer, List<Tweet>>();
        userFollows = new HashMap<Integer, Set<Integer>>();
        timeStamp = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet post = new Tweet(timeStamp, tweetId);
        timeStamp++;
        List<Tweet> currentTimeline;
        if( userTimeline.containsKey(userId) )
            currentTimeline = userTimeline.get(userId);
        else
            currentTimeline = new LinkedList<Tweet>();
        currentTimeline.add(0, post);
        userTimeline.put(userId, currentTimeline);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> temp = new LinkedList<Tweet>();
        
        Set<Integer> myFollowee;
        if( userFollows.containsKey(userId))
            myFollowee = userFollows.get(userId);
        else
            myFollowee = new HashSet<Integer>();
        myFollowee.add(userId);
        Iterator<Integer> itr = myFollowee.iterator();
        while( itr.hasNext() ) {
            Integer current = itr.next();
            List<Tweet> currentPosts = (userTimeline.containsKey(current)) ? userTimeline.get(current) : (new LinkedList<Tweet>());
            for(int i=0; i<Math.min(10, currentPosts.size()); i++)
                temp.add(currentPosts.get(i));
        }
        myFollowee.remove(userId);
        //System.out.println(temp.toString());
        Collections.sort(temp, new Comparator<Tweet>() {
            public int compare(Tweet o1, Tweet o2) {
                return -Integer.compare(o1.timeId, o2.timeId);
            }
        });
        
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0; i<Math.min(10, temp.size()); i++)
            ans.add(temp.get(i).tweetId);
        return ans;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if( followerId == followeeId )
            return;
        Set<Integer> myFollowee;
        if( userFollows.containsKey(followerId) )
            myFollowee = userFollows.get(followerId);
        else
            myFollowee = new HashSet<Integer>();
        myFollowee.add(followeeId);
        userFollows.put(followerId, myFollowee);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> myFollowee = userFollows.get(followerId);
        if( myFollowee == null)
            return;
        myFollowee.remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */