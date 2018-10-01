package com.liyin.util;

import org.springframework.context.ApplicationContext;
/**
 * 项目名称：
 * @author:fh
 * 
*/
public class Const {
	public static final String SESSION_SECURITY_CODE = "sessionSecCode";
	public static final String SESSION_USER = "sessionUser";
	public static final String SESSION_ROLE_RIGHTS = "sessionRoleRights";
	public static final String SESSION_menuList = "menuList";			//当前菜单
	public static final String SESSION_allmenuList = "allmenuList";		//全部菜单
	public static final String SESSION_QX = "QX";
	public static final String SESSION_userpds = "userpds";			
	public static final String SESSION_USERROL = "USERROL";				//用户对象
	public static final String SESSION_USERNAME = "USERNAME";			//用户名
	public static String SESSION_APP_TOKEN = "USERTOKEN";	//app用户登陆token凭据
	public static String SESSION_APP_ACCOUNTNAME = "ACCOUNTNAME";
	public static String SESSION_APP_VERIFYCODE = "VERIFYCODE";
	public static final String TRUE = "T";
	public static final String FALSE = "F";
	public static final String LOGIN = "/login_toLogin.do";				//登录地址
	public static final String SYSNAME = "admin/config/SYSNAME.txt";	//系统名称路径
	public static final String PAGE	= "admin/config/PAGE.txt";			//分页条数配置路径
	public static final String EMAIL = "admin/config/EMAIL.txt";		//邮箱服务器配置路径
	public static final String SMS1 = "admin/config/SMS1.txt";			//短信账户配置路径1
	public static final String SMS2 = "admin/config/SMS2.txt";			//短信账户配置路径2
	public static final String FWATERM = "admin/config/FWATERM.txt";	//文字水印配置路径
	public static final String IWATERM = "admin/config/IWATERM.txt";	//图片水印配置路径
	public static final String WEBSOCKET = "admin/config/WEBSOCKET.txt";//WEBSOCKET配置路径
//	public static final String FILEPATHIMG = "/uploadImgs/";	//图片上传路径
//	public static final String FILEPATHFILE = "/uploadFiles/";		//文件上传路径
	public static final String FILEPATHTWODIMENSIONCODE = "uploadFiles/twoDimensionCode/"; //二维码存放路径
	public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(code)|(app)|(weixin)|(static)|(main)|(websocket)).*";	//不对匹配该值的访问路径拦截（正则）
	//public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(code)|(weixin)|(static)|(main)|(websocket)).*";	//不对匹配该值的访问路径拦截（正则）,财务管理，开户申请管理路径是以app开头，所以此处去掉app的不校验配置
	
	//文件及图片上传路径分类 start(basePath/类型分类/id/日期/具体图片名称)
	public static final String FILEPATH_VERSION = "/version/";	//版本相关
	public static final String FILEPATH_PRODUCT = "/product/";	//产品相关
	public static final String FILEPATH_CATRACT = "/contract/";	//合同相关
	public static final String FILEPATH_BASEINFO = "/baseinfo/";	//企业基本信息相关
	public static final String FILEPATH_UEEDITOR = "/ueeditor/";	//网页编辑器图片相关
	public static final String FILEPATH_SHUIYIN = "/shuiyin/";	//水印文件
	public static final String FILEPATH_YUNING = "/yunying/";	//运营后台轮播图、金融产品、服务中心
	public static final String FILEPATH_EXPORTING = "/export/";	//运营后台导出文件
	public static final String FILEPATH_IMPORTING = "/import/";	//运营后台导入文件
	public static final String FILEPATH_REQUIRE = "/require/";	//需求相关
	public static final String FILEPATH_QUALITY = "/quality/";	//质检相关
	public static final String FILEPATH_REJECTED = "/rejected/";	//退货相关
	public static final String FILEPATH_FINANCE_PRO = "/financepro/";	//金融产品相关
	//文件及图片上传路径分类 end
	public static ApplicationContext WEB_APP_CONTEXT = null; //该值会在web容器启动时由WebAppContextListener初始化
	
	/**
	 * APP Constants
	 */
    //安卓APP安装包文件名，konglc，2016-10-7
	public static final String APP_APK_FILENAME = "UCACC";
	
	//app注册接口_请求协议参数)
	public static final String[] APP_REGISTERED_PARAM_ARRAY = new String[]{"countries","uname","passwd","title","full_name","company_name","countries_code","area_code","telephone","mobile"};
	public static final String[] APP_REGISTERED_VALUE_ARRAY = new String[]{"国籍","邮箱帐号","密码","称谓","名称","公司名称","国家编号","区号","电话","手机号"};
	
	//app根据用户名获取会员信息接口_请求协议中的参数
	public static final String[] APP_GETAPPUSER_PARAM_ARRAY = new String[]{"USERNAME"};
	public static final String[] APP_GETAPPUSER_VALUE_ARRAY = new String[]{"用户名"};
	
    //app调用接口返回提示信息
	//public static final String APP_IMG_SHOW = "/uploadFile/";	
	public static final String APP_CODE_SHOW = "code";
	public static final String APP_MSG_SHOW = "msg";
	public static final String APP_DATA_SHOW = "data";
	public static final String APP_DATA_TOKEN = "token";
	public static final String APP_ISERROR_CODE_200 = "200";
	public static final String APP_ISERROR_CODE_400 = "400";
	public static final String APP_ISERROR_CODE_401 = "401";
	public static final String APP_ISERROR_CODE_500 = "500";
	public static final String APP_ISERROR_MSG_200 = "success";//请求成功
	public static final String APP_ISERROR_MSG_400 = "parameter error";	//参数错误
	public static final String APP_ISERROR_MSG_401 = "unlawful user";    //非法用户（验证失败）
	public static final String APP_ISERROR_MSG_500 = "server error";    //服务器错误
	//企业超级用户权限
	public static final String CORPORATE_BUYER_ROLE_ID = "4001";
	public static final String CORPORATE_SUPPLY_ROLE_ID = "6001";
	public static final String CORPORATE_SERVICE_ROLE_ID = "7001";
	public static final String CORPORATE_BUYERANDSUPPLY_ROLE_ID = "5001";
	public static final String CORPORATE_INDIVIDUALUSER_ROLE_ID = "8001";
	/**
	 * 保证金类型
	 * 01-发起招标
	 */
	public static final String DEPOSIT_TYPE_ZB = "01";
	/**
	 * 保证金类型
	 * 02-发起投标
	 */
	public static final String DEPOSIT_TYPE_TB = "02";
	public static final String COOKIE_CARGOOD_GOODSID = "cart_";
	
}
