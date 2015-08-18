package com.pitaya.metor.enums;

/**
 * 站台枚举
 * @author boli
 *
 */
public enum MetroStationsEnum {
	/**
	 * 罗宝线
	 */
	luohu				(1,  "罗湖"),
	guomao				(2,  "国贸"),
	laojie				(3,  "老街"),
	dajuyuan			(4,  "大剧院"),
	kexueguan			(5,  "科学馆"),
	huaqianglu			(6,  "华强路"),
	gangxia 			(7,  "岗厦"),
	huizhanzhongxin		(8,  "会展中心"),
	gouwugongyuan 		(9,  "购物公园"),
	xiangmihu 			(10, "香蜜湖"),
	chegongmiao			(11, "车公庙"),
	zhuzilin			(12, "竹子林"),
	qiaochengdong		(13, "侨城东"),
	huaqiaocheng 		(14, "华侨城"),
	shijiezhichuang		(15, "世界之窗"),
	baishizhou			(16, "白石洲"),
	gaoxinyuan 			(17, "高新园"),
	shenda				(18, "深大"),
	taoyuan 			(19, "桃园"),
	daxin 				(20, "大新"),
	liyumen				(21, "鲤鱼门"),
	qianhaiwan			(22, "前海湾"),
	xinan				(23, "新安"),
	baoanzhongxin		(24, "宝安中心"),
	baoti				(25, "宝体"),
	pingzhou			(26, "坪洲"),
	xixiang				(27, "西乡"),
	gushu				(28, "固戍"),
	hourui				(29, "后瑞"),
	jichangdong			(30, "机场东");
	
	/**
	 * 蛇口线
	 */
	
	/**
	 * 龙岗线
	 */
	
	/**
	 * 龙华线
	 */
	
	/**
	 * 环中线
	 */
	
	Integer code;
	String name;
	
	private MetroStationsEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
	}
}
