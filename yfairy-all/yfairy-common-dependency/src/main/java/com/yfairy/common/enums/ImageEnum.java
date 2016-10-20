package com.yfairy.common.enums;

public enum ImageEnum {
	BMP("BMP"), GIF("GIF"), EPS("EPS"), DCS("DCS"), JPEG("JPEG"), JPG("JPG"), JPE("JPE"), PCX("PCX"), PDF("PDF"), RAW(
			"RAW"), PICT("PICT"), PXR("PXR"), PNG("PNG"), SCT("SCT"), TIFF("TIFF"), Targa("Targa");
	private String value;

	private ImageEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
