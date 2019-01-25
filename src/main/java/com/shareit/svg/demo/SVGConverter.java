package com.shareit.svg.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.fop.svg.PDFTranscoder;

/**
 * 类说明
 * 
 * @author geai
 * @date 2019年1月22日 新建
 */
public class SVGConverter {

	/**
	 * SVG转PNG
	 * 
	 * @param svgCode
	 *            SVG代码
	 * @param outpath
	 *            输出路径
	 * @throws TranscoderException
	 * @throws IOException
	 */
	public void svg2PNG(String svgCode, String outpath)
			throws TranscoderException, IOException {
		Transcoder transcoder = new PNGTranscoder();
		svgConverte(svgCode, outpath, transcoder);
	}

	/**
	 * SVG转PNG
	 * 
	 * @param svgCode
	 *            SVG代码
	 * @param out
	 *            输出流
	 * @throws TranscoderException
	 * @throws IOException
	 */
	public void svg2PNG(String svgCode, OutputStream out)
			throws TranscoderException, IOException {
		Transcoder transcoder = new PNGTranscoder();
		svgConverte(svgCode, out, transcoder);
	}

	/**
	 * SVG转PNG
	 * 
	 * @param svgFile
	 *            SVG文件
	 * @param outFile
	 *             输出文件
	 * @throws TranscoderException
	 * @throws IOException
	 */
	public void svg2PNG(File svgFile, File outFile)
			throws TranscoderException, IOException {
		Transcoder transcoder = new PNGTranscoder();
		svgConverte(svgFile, outFile, transcoder);
	}

	/**
	 * SVG转JPG
	 * 
	 * @param svgCode
	 *            SVG代码
	 * @param outpath
	 *            输出路径
	 * @throws TranscoderException
	 * @throws IOException
	 */
	public void svg2JPEG(String svgCode, String outpath)
			throws TranscoderException, IOException {
		Transcoder transcoder = new JPEGTranscoder();
		// 为防止ERROR: The JPEG quality has not been specified. Use the default
		// one: no compression 错误，需如下配置
		transcoder.addTranscodingHint(JPEGTranscoder.KEY_QUALITY, 0.99f);
		svgConverte(svgCode, outpath, transcoder);
	}

	/**
	 * SVG转JPG
	 * 
	 * @param svgCode
	 *            SVG代码
	 * @param out
	 *            输出流
	 * @throws TranscoderException
	 * @throws IOException
	 */
	public void svg2JPEG(String svgCode, OutputStream out)
			throws TranscoderException, IOException {
		Transcoder transcoder = new JPEGTranscoder();
		// 为防止ERROR: The JPEG quality has not been specified. Use the default
		// one: no compression 错误，需如下配置
		transcoder.addTranscodingHint(JPEGTranscoder.KEY_QUALITY, 0.99f);
		svgConverte(svgCode, out, transcoder);
	}

	/**
	 * SVG转JPG
	 * 
	 * @param svgFile
	 *            SVG文件
	 * @param outFile
	 *             输出文件
	 * @throws TranscoderException
	 * @throws IOException
	 */
	public void svg2JPEG(File svgFile, File outFile)
			throws TranscoderException, IOException {
		Transcoder transcoder = new JPEGTranscoder();
		// 为防止ERROR: The JPEG quality has not been specified. Use the default
		// one: no compression 错误，需如下配置
		transcoder.addTranscodingHint(JPEGTranscoder.KEY_QUALITY, 0.99f);
		svgConverte(svgFile, outFile, transcoder);
	}

	/**
	 * SVG转PDF
	 * 
	 * @param svgCode
	 *            SVG代码
	 * @param outpath
	 *            输出路径
	 * @throws TranscoderException
	 * @throws IOException
	 */
	public void svg2PDF(String svgCode, String outpath)
			throws TranscoderException, IOException {
		Transcoder transcoder = new PDFTranscoder();
		svgConverte(svgCode, outpath, transcoder);
	}

	/**
	 * SVG转PDF
	 * 
	 * @param svgCode
	 *            SVG代码
	 * @param out
	 *            输出流
	 * @throws TranscoderException
	 * @throws IOException
	 */
	public void svg2PDF(String svgCode, OutputStream out)
			throws TranscoderException, IOException {
		Transcoder transcoder = new PDFTranscoder();
		svgConverte(svgCode, out, transcoder);
	}

	/**
	 * SVG转PDF
	 * 
	 * @param svgFile
	 *            SVG文件
	 * @param outFile
	 *             输出文件
	 * @throws TranscoderException
	 * @throws IOException
	 */
	public void svg2PDF(File svgFile, File outFile)
			throws TranscoderException, IOException {
		Transcoder transcoder = new PDFTranscoder();
		svgConverte(svgFile, outFile, transcoder);
	}

	private void svgConverte(String svgCode, String outpath,
			Transcoder transcoder) throws IOException, TranscoderException {
		svgConverte(svgCode, getOutputStream(outpath), transcoder);
	}

	private void svgConverte(File svg, File outFile, Transcoder transcoder)
			throws IOException, TranscoderException {
		svgConverte(svg2String(getInputStream(svg)), getOutputStream(outFile),
				transcoder);
	}

	private void svgConverte(String svgCode, OutputStream out,
			Transcoder transcoder) throws IOException, TranscoderException {
		svgCode = svgCode.replaceAll(":rect", "rect");
		TranscoderInput input = new TranscoderInput(new StringReader(svgCode));
		TranscoderOutput output = new TranscoderOutput(out);
		svgConverte(input, output, transcoder);
	}

	private void svgConverte(TranscoderInput input, TranscoderOutput output,
			Transcoder transcoder) throws IOException, TranscoderException {
		transcoder.transcode(input, output);
	}

	public InputStream getInputStream(File file) throws IOException {
		return new FileInputStream(file);
	}

	public InputStream getInputStream(String filepath) throws IOException {
		File file = new File(filepath);
		if (file.exists())
			return getInputStream(file);
		else
			return null;
	}

	public OutputStream getOutputStream(File outFile) throws IOException {
		return new FileOutputStream(outFile);
	}

	public OutputStream getOutputStream(String outpath) throws IOException {
		File file = new File(outpath);
		if (!file.exists())
			file.createNewFile();
		return getOutputStream(file);
	}

	/**
	 * 默认使用编码UTF-8  SVG文件输入流转String 
	 * 
	 * @param svgFile
	 * @return SVG代码
	 * @throws IOException 
	 */
	public String svg2String(File svgFile) throws IOException {
		InputStream in = getInputStream(svgFile);
		return svg2String(in, "UTF-8");
	}

	/**
	 * SVG文件输入流转String 
	 * 
	 * @param svgFile
	 * @return SVG代码
	 * @throws IOException 
	 */
	public String svg2String(File svgFile, String charset) throws IOException {
		InputStream in = getInputStream(svgFile);
		return svg2String(in, charset);
	}

	/**
	 * 默认使用编码UTF-8  SVG输入流转String 
	 * 
	 * @param in
	 * @return SVG代码
	 */
	public String svg2String(InputStream in) {
		return svg2String(in, "UTF-8");
	}

	/**
	 * 指定字符集SVG输入流转String
	 * 
	 * @param in
	 *            输入流
	 * @param charset
	 *            字符编码
	 * @return SVG代码
	 */
	public String svg2String(InputStream in, String charset) {
		StringBuffer svgBuffer = new StringBuffer();
		BufferedReader bfr = null;
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(in,
					charset);
			bfr = new BufferedReader(inputStreamReader);
			String line = "";
			while ((line = bfr.readLine()) != null) {
				svgBuffer.append(line);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bfr != null)
					bfr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return svgBuffer.toString();
	}
}
