package com.pitaya.metor.enums;

public enum SZMetrosEnum {
	
	LUO_BAO		(1, "罗宝线"),
	SHE_KOU		(2, "蛇口线"),
	LONG_GANG	(3, "龙岗线"),
	LONG_HUA	(4,	"龙华线"),
	HUAN_ZHONG	(5,	"环中线");
	
	Integer code;
	String name;

	private SZMetrosEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	public static SZMetrosEnum getInstance(Integer code) {
		for(SZMetrosEnum szMetrosEnum : values()) {
			if (szMetrosEnum.getCode().equals(code)) {
				return szMetrosEnum;
			}
		}
		return null;
	}
}

