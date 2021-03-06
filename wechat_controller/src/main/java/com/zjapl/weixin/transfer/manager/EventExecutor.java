package com.zjapl.weixin.transfer.manager;

import com.zjapl.weixin.transfer.bean.AppInfo;
import com.zjapl.weixin.transfer.bean.EventInfo;
import com.zjapl.weixin.transfer.bean.User;
import com.zjapl.weixin.transfer.service.UserService;
import com.zjapl.weixin.transfer.utils.EventInfoUtils;

/**
 * 事件处理
 * @author yangb
 *
 */
public class EventExecutor extends EventAbstract {
	public AppInfo app;
	
	/**
	 * @param app
	 */
	public EventExecutor(AppInfo app) {
		super();
		this.app = app;
	}

	@Override
	public String getAppName() {
		return app.getAppname();
	}

	@Override
	public EventInfo handleText(EventInfo reqInfo) {
		
		String content = EventInfoUtils.getTextContent(reqInfo); //获取文本消息的内容
		String appid = app.getAppid();//获取appid
		String appname = app.getAppname(); //获取公众号账号.
		System.out.println("公众号 " + appname + " 收到一条消息:" + content);
		String replay = "公众号账号: " + appname + "; 公众号appid:" + appid;
		return EventInfoUtils.replayText(reqInfo, replay); //回复文本消息
	}

	@Override
	public EventInfo handleVoice(EventInfo reqInfo) {
		return null;
	}

	@Override
	public EventInfo handleImage(EventInfo reqInfo) {
		return null;
	}

	@Override
	public EventInfo handleVideo(EventInfo reqInfo) {
		return null;
	}

	@Override
	public EventInfo handleShortVideo(EventInfo reqInfo) {
		return null;
	}

	@Override
	public EventInfo handleLocation(EventInfo reqInfo) {
		return null;
	}

	@Override
	public EventInfo handleLink(EventInfo reqInfo) {
		return null;
	}

	@Override
	public EventInfo subscribe(String openid) {
		UserService us = new UserService();
		User user = us.obtainUserInfo(openid, app.getAppid()).getData();
		return subscribeDetail(user);
	}

	/**
	 * 关注用户的详细信息
	 * @param user
	 * @return
	 */
	public EventInfo subscribeDetail(User user){
		
		return null;
	}
	
	@Override
	public void unsubscribe(String openid) {
		
	}

	@Override
	public EventInfo scan(String openid) {
		
		return null;
	}

	@Override
	public EventInfo custom(EventInfo event) {
		event.getEventKey();
		
		return null;
	}

}
