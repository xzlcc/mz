package com.mz.xmz.utils;

import android.content.Context;
import android.content.res.Resources;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Locale;

/**
 * 操作字符串的工具类。
 * 
 */
public final class TextUtil {

	/**
	 * 比较2个字符串是否相等。
	 * 
	 * @Title equals
	 * @Description 比较2个字符串是否相等。
	 * 
	 * @param str1
	 * @param str2
	 * @return 若 str1、str2 都为 null 则返回true，否则调用 {@link String#equals(Object)} 方法进行判断，该方法处理了空指针异常。
	 */
	public static boolean equals(String str1, String str2) {
		if (str1 == null) {
			return (str2 == null);
		}
		return str1.equals(str2);
	}

	/**
	 * 封装 {@link String#trim()} 方法，避免空指针异常。
	 * 
	 * @Title trim
	 * @Description 封装 {@link String#trim()} 方法，避免空指针异常。
	 * 
	 * @param value
	 * @return
	 */
	public static String trim(String value) {
		if (value == null) {
			return value;
		}
		return value.trim();
	}

	/**
	 * 判断给定的字符串是否为空（忽略字符串开头、结尾的空格）。
	 * 
	 * @Title isEmpty
	 * @Description 判断给定的字符串是否为空（忽略字符串开头、结尾的空格）。
	 * 
	 * @param value
	 * @return  true  空或null
	 */
	public static boolean isEmpty(CharSequence value) {
		if (value == null ||"null".equals(value) || value.toString().trim().length() == 0) {
			return true;
		}
		return false;
	}
    
    public static boolean isEmptyInt(CharSequence value){
        if(value == null || "null".equals(value) || "0".equals(value) || "0.0".equals(value) || "0.000".equals(value) || value.toString().trim().length() == 0){
            return true;
        }
        return false;
    }

	/**
	 * 封装 {@link Resources#getString(int)} 方法，处理异常。
	 * 
	 * @Title getString
	 * @Description 封装 {@link Resources#getString(int)} 方法，处理异常。
	 * 
	 * @param context
	 * @param resId
	 * @return 若发生异常返回 ""
	 */
	public static String getString(Context context, int resId) {
		if (context == null) {
			return "";
		}
		try {
			return context.getString(resId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 封装 {@link Resources#getText(int)} 方法，处理异常。
	 * 
	 * @Title getText
	 * @Description 封装 {@link Resources#getText(int)} 方法，处理异常。
	 * 
	 * @param context
	 * @param resId
	 * @return 若发生异常返回 ""
	 */
	public static CharSequence getText(Context context, int resId) {
		if (context == null) {
			return "";
		}
		try {
			return context.getText(resId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 封装 {@link Resources#getTextArray(int)} 方法，处理异常。
	 * 
	 * @Title getTextArray
	 * @Description 封装 {@link Resources#getTextArray(int)} 方法，处理异常。
	 * 
	 * @param context
	 * @param resId
	 * @return 若异常返回空数组
	 */
	public static CharSequence[] getTextArray(Context context, int resId) {
		if (context == null) {
			return new CharSequence[0];
		}
		try {
			return context.getResources().getTextArray(resId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new CharSequence[0];
	}

	/**
	 * 封装 {@link String#format(String, Object...)} 方法，格式化字符串。 <br>
	 * 占位符格式为：<b>%[index]$[type]</b>。
	 * 
	 * @Title formatStrings
	 * @Description 格式化指定资源的字符串。
	 * 
	 * @param context
	 * @param resId
	 *            字符串资源的id。
	 * @param args
	 * @return 若指定的资源不存在则返回 ""
	 */
	public static String formatStrings(Context context, int resId, Object... args) {
		if (context == null) {
			return "";
		}
		return formatStrings(getString(context, resId), args);
	}

	/**
	 * 封装 {@link String#format(String, Object...)} 方法，格式化字符串。<br>
	 * 占位符格式为：<b>%[index]$[type]</b>。
	 * 
	 * @Title formatStrings
	 * @Description 格式化指定的字符串。
	 * 
	 * @param format
	 * @param args
	 * @return
	 */
	public static String formatStrings(String format, Object... args) {
		return String.format(format, args);
	}

	/**
	 * 封装 {@link String#format(String, Object...)} 方法，格式化字符串。<br>
	 * 占位符格式为：<b>%[index]$[type]</b>。<br>
	 * 
	 * @Title formatString
	 * @Description 格式化指定的字符串。
	 * 
	 * @param format
	 * @param arg
	 *            如果该值为 null 则自动替换为 ""
	 * @return
	 */
	public static String formatString(String format, Object arg) {
		if (arg == null) {
			return String.format(format, "");
		}
		return String.format(format, arg);
	}

	/**
	 * 封装 {@link String#format(String, Object...)} 方法，格式化字符串。 <br>
	 * 占位符格式为：<b>%[index]$[type]</b>。
	 * 
	 * @Title formatString
	 * @Description 格式化指定资源的字符串。
	 * 
	 * @param context
	 * @param resId
	 * @param arg
	 *            如果该值为 null 则自动替换为 ""
	 * @return
	 */
	public static String formatString(Context context, int resId, Object arg) {
		if (context == null) {
			return "";
		}
		String format = getString(context, resId);
		if (arg == null) {
			return String.format(format, "");
		}
		return String.format(format, arg);
	}

	/**
	 * 判断给定的字符串是否为完整的 URL 地址<b>（形如：<i>http://www.xxx.com</i> 格式）</b>。
	 * 
	 * @Title isFullUrl
	 * @Description 判断给定的字符串是否为完整的 URL 地址。
	 * 
	 * @param url
	 * @return
	 */
	public static boolean isFullUrl(String url) {
		if (url == null) {
			return false;
		}
		final String urlLowerCase = url.toLowerCase(Locale.getDefault());
		if (urlLowerCase.startsWith("http://")) {
			return true;
		}
		if (urlLowerCase.startsWith("https://")) {
			return true;
		}
		return false;
	}

	/**
	 * 获取给定 URL 的 host。
	 * 
	 * @Title getHostFromUrl
	 * @Description 获取给定 URL 的 host。
	 * 
	 * @param url
	 * @return
	 */
	public static String getHostFromUrl(String url) {
		if (url == null) {
			return "";
		}
		int indexEnd = -1;
		final String urlLowerCase = url.toLowerCase(Locale.getDefault());
		if (urlLowerCase.startsWith("http://")) {
			indexEnd = url.indexOf("/", url.indexOf("http://") + 8);
		}
		if (urlLowerCase.startsWith("https://")) {
			indexEnd = url.indexOf("/", url.indexOf("https://") + 9);
		}
		if (indexEnd == -1) {
			return url;
		}
		String host = url.substring(0, indexEnd);
		return host;
	}

	/**
	 * 获取给定的 URL 的路径部分。
	 * 
	 * @Title getPathFromUrl
	 * @Description 获取给定的 URL 的路径部分。
	 * 
	 * @param url
	 * @return
	 */
	public static String getPathFromUrl(String url) {
		if (url == null) {
			return "";
		}
		int indexStart = -1;
		final String urlLowerCase = url.toLowerCase(Locale.getDefault());
		if (urlLowerCase.startsWith("http://")) {
			indexStart = url.indexOf("/", url.indexOf("http://") + 8);
		}
		if (urlLowerCase.startsWith("https://")) {
			indexStart = url.indexOf("/", url.indexOf("https://") + 9);
		}
		if (indexStart == -1) {
			return url;
		}
		String uri = url.substring(indexStart);
		return uri;
	}

	/**
	 * 截取字符串，根据开始和结束的字符串截取中间部分（不包括开始和结束的字符串）。<br>
	 * 
	 * 如果 finish 为空则截取到源字符串的末尾。
	 * 
	 * @Title getSubString
	 * @Description 截取字符串，根据开始和结束的字符串截取中间部分（不包括开始和结束的字符串）。
	 * 
	 * @param src
	 * @param begin
	 * @param finish
	 * @return
	 */
	public static String getSubString(String src, String begin, String finish) {
		int start = src.indexOf(begin);

		if (finish == null || "".equals(finish)) {
			if (start >= 0) {
				String result = src.substring(start + begin.length());
				return result;
			}
		}

		int end = src.lastIndexOf(finish);
		if (end <= 0) {
			end = src.length();
		}

		if (start >= 0 && (start + begin.length()) < end) {
			String result = src.substring((start + begin.length()), end);
			return result;
		}
		return "";
	}

	/**
	 * 把给定字符串的第一个字母变成大写。
	 * 
	 * @Title toFirstLetterUpperCase
	 * @Description 把给定字符串的第一个字母变成大写。
	 * 
	 * @param value
	 * @return
	 */
	public String toFirstLetterUpperCase(String value) {
		if (value == null || value.length() == 0) {
			return "";
		}
		if (value.length() == 1) {
			return value.toUpperCase(Locale.getDefault());
		}
		String firstLetter = value.substring(0, 1).toUpperCase(Locale.getDefault());
		return firstLetter + value.substring(1, value.length());
	}

	/**
	 * 使用 UTF-8 编码对给定的字符串做 URLDecode。<br>
	 * 
	 * @Title decodeUTF8
	 * @Description 使用 UTF-8 编码对给定的字符串做 URLDecoder。
	 * 
	 * @param value
	 * @return
	 */
	public static String decodeUTF8(String value) {
		try {
			return URLDecoder.decode(value, "UTF-8");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 对给定的字符串做 URLEncode，并把 encode 结果中的 "+" 全部替换成 "%20"。
	 * 
	 * @Title encodeUTF8
	 * @Description 对给定的字符串做 URLEncode，并把 encode 结果中的 "+" 全部替换成 "%20"。
	 * 
	 * @param value
	 * @return
	 */
	public static String encodeUTF8(String value) {
		String result = "";
		try {
			result = URLEncoder.encode(value, "UTF-8");
			if (result != null) {
				result = result.replaceAll("\\+", "%20");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	
	/** 
     * 半角转换为全角 
     *  
     * @param input 
     * @return 
     */  
    public static String ToDBC(String input) {
        char[] c = input.toCharArray();  
        for (int i = 0; i < c.length; i++) {  
            if (c[i] == 12288) {  
                c[i] = (char) 32;  
                continue;  
            }  
            if (c[i] > 65280 && c[i] < 65375)  
                c[i] = (char) (c[i] - 65248);  
        }  
        return new String(c);
    }
    
    
    /**
     * 处理string类型的数字 第一位为小数点时 小数点前面补加0 列如.01 = 0,01
     *
     * @param num
     *
     * @return
     */
    public static String editFloat(String num){
        if(num.length() > 1 && num.substring(0 , 1).equals(".")){
            num = "0" + num;
        }
        return num;
    }
}
