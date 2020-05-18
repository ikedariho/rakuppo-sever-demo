package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.User;
import com.example.domain.response.LoginUser;

/**
 * ユーザーマッパー.
 * 
 * @author yosuke.yamada
 *
 */
@Mapper
public interface UserMapper {

	/**
	 * ユーザ登録をするmapper.
	 * 
	 * @param user 登録するユーザー
	 * @return 登録したユーザのID
	 */
	public Integer insertUser(User user);

	/**
	 * 全件検索するマッパー.
	 * 
	 * @return ユーザリスト ユーザー情報を全件取得
	 * 
	 */
	public List<User> findAll();

	/**
	 * 新規ユーザ登録時、登録したuserのidを登録するメソッド.
	 * 
	 * @param userId
	 */
	public void updateRegisterUserId(Integer userId);

	/**
	 * 全ユーザー情報とそのユーザーの投稿一覧を取得するメソッド.
	 * 
	 * @return 全ユーザー情報とその投稿の一覧
	 */
	public List<User> findAllAndDailyPost();

	/**
	 * メールからユーザー情報を検索する.
	 * 
	 * @return ユーザー情報
	 */
	public LoginUser findByMailAndAuthority(String mail);

	/**
	 * メールアドレスからユーザー情報を取得する.
	 * 
	 * @param email メール
	 * @return ユーザー情報
	 */
	public User findUserByMail(String email);

	/**
	 * ユーザー登録を更新する
	 * 
	 * @param user ユーザー情報
	 */
	public void updateUser(User user);

	/**
	 * 部署IDで該当の部署に所属している人数を取得するメソッド
	 * 
	 * @param depId 部署ID
	 * @return 所属人数
	 */
	public Integer countByDepId(Integer depId);
	
	
	//テスト用
	public void insertUsers();

}