package No355;

import java.util.*;

/**
 * @author ChrisPeng
 * @date 2022/8/16 19:17
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Twitter {
    /**
     * 每个用户表示一个结点
     * 每个节点包含：
     * 1. 关注的用户，用列表实现
     * 2. 推文列表（按时间顺序排列）
     * 推文包含：推特id，计数时间，用户id
     */
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, Integer> postMap;
    LinkedList<Integer> timeLinePosts;
    final int maxFeeds = 10;

    public Twitter() {
        followMap = new HashMap<>();
        postMap = new HashMap<>();
        timeLinePosts = new LinkedList<>();
    }

    public void postTweet(int userId, int tweetId) {
        postMap.put(tweetId, userId);
        timeLinePosts.addFirst(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        followMap.putIfAbsent(userId, new HashSet<>());
        Set<Integer> followSet = followMap.get(userId);
        followSet.add(userId);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < timeLinePosts.size(); i++) {
            Integer tweetId = timeLinePosts.get(i);
            Integer uid = postMap.get(tweetId);
            if (res.size() < maxFeeds && followSet.contains(uid))
                res.add(tweetId);
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).remove(Integer.valueOf(followeeId));
    }
}