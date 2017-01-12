package com.wd.Weblogic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;

import com.wd.Dao.MeinvMapper;
import com.wd.Enity.Meinv;
import com.wd.Tools.DBTools;

//import com.wd.CoilingDragon.Enity.Book;
//import com.wd.CoilingDragon.Pipline.BookPipline;
//import com.wd.CoilingDragon.WebMagic.BookWebMagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

//92 美女网站
public class NineTwoMeiNv implements PageProcessor{

	public static final String URL_Base = "http://m.92mntu.com";

//	public static final String Regex = "http://www.wuxiaworld.com/cdindex-html/(\\w+)/.*";

	  // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(5000);
    SqlSession session = DBTools.getSession();
	public void process(Page page) {
		System.out.println("start");
		// 
		final String regex = "(?<=<a href=\")(.*?)(?=\").*?(?<=title=\")(.*?)(?=\").*?(?<=<img src=\")(.*?)(?=\").*?(?<=p>)(.*?)(?=<\\/p>)";
		final Pattern pattern = Pattern.compile(regex);
    	   
		
		// TODO Auto-generated method stub
//    	 if(page.getRequest().toString().equals(URL_Base)){
			List<String> meiNvList = page.getHtml().xpath("div[@class='post']").all();
			for (int i = 0; i < meiNvList.size(); i++) {
				MeinvMapper mapper = session.getMapper(MeinvMapper.class);
				Matcher matcher = pattern.matcher(meiNvList.get(i));
		        while (matcher.find()) {
		        	Meinv meinv = new Meinv();
					for (int index = 1; index <= matcher.groupCount(); index++) {
				    	if(index==1){	
							meinv.setOriginUrl(matcher.group(1));
				        }
				        if(index==2){	
							meinv.setTitle(matcher.group(2));
//							System.out.println(meinv.getTitle().getBytes());
							
							System.getProperty(meinv.getTitle());
				        }
				        if(index==3){	
							meinv.setImgUrl(matcher.group(3));
				        }
				        if(index==4){	
							meinv.setCatalogue(matcher.group(4));
				        }
				    }			        
				try {
					System.out.println("插入数据库之前的数据位:"+meinv.toString());
			        mapper.insert(meinv);
					session.commit();
					System.out.println("插入后的数据为:"+mapper.selectByPrimaryKey(meinv.getId()).toString());
				} catch (Exception e) {
					e.printStackTrace();
					session.rollback();
				}finally {
//					session.close();
				}

		        }
		        
			}
//    	 }
    	 System.out.println("url " +page.getRequest().toString());
	     System.out.println("over");
	}

	public Site getSite() {
		// TODO Auto- method stub
		return site;
	}
	
	  public static void main(String[] args) {

	        Spider.create(new NineTwoMeiNv())
	                //从"https://github.com/code4craft"开始抓
	                .addUrl(URL_Base)
//	                .addPipeline(new JsonFilePipeline())
	                //开启5个线程抓取
	                .thread(3)
	                //启动爬虫
	                .run();
	    }
}
