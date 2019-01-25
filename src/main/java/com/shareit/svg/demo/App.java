package com.shareit.svg.demo;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		// String svgpath =
		// "C:\\Users\\HC\\Desktop\\html\\svg\\svgconvert\\test.svg";
		//123
		String svgpath = "C:\\Users\\Vincent\\Desktop\\11.svg";
		File svgFile = new File(svgpath);
		String name = svgFile.getName();
		name = name.substring(0, name.lastIndexOf("."));
		SVGConverter converter = new SVGConverter();
		converter.svg2PDF(new File(svgpath),
				new File("C:\\Users\\Vincent\\Desktop\\SVG\\" + name + "_SVG文件转PDF.pdf"));
		converter.svg2PNG(new File(svgpath),
				new File("C:\\Users\\Vincent\\Desktop\\SVG\\" + name + "_SVG文件转PNG.png"));
		converter.svg2JPEG(new File(svgpath),
				new File("C:\\Users\\Vincent\\Desktop\\SVG\\" + name + "_SVG文件转JPG.jpg"));
		String svgCode = converter.svg2String(new File(svgpath));
		converter.svg2PDF(svgCode, "C:\\Users\\Vincent\\Desktop\\SVG\\" + name + "_SVG代码转PDF.pdf");
		converter.svg2PNG(svgCode, "C:\\Users\\Vincent\\Desktop\\SVG\\"+ name + "_SVG代码转PNG.png");
		converter.svg2JPEG(svgCode,"C:\\Users\\Vincent\\Desktop\\SVG\\" + name + "_SVG代码转JPG.jpg");
		converter.svg2PDF(svgCode, new FileOutputStream(
				new File("C:\\Users\\Vincent\\Desktop\\SVG\\" + name + "_SVG代码转输出流.pdf")));
		converter.svg2PNG(svgCode, new FileOutputStream(
				new File("C:\\Users\\Vincent\\Desktop\\SVG\\" + name + "_SVG代码转输出流.png")));
		converter.svg2JPEG(svgCode, new FileOutputStream(
				new File("C:\\Users\\Vincent\\Desktop\\SVG\\" + name + "_SVG代码转输出流.jpg")));
	}

}
