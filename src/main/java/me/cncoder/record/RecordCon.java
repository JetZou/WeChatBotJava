package me.cncoder.record;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import me.biezhi.wechat.Constant;
import me.biezhi.wechat.model.WechatMeta;

import com.blade.kit.json.JSONObject;

public class RecordCon {

	//记录上一次自动回复的联系人数组列表,20分钟清空一次
	public static List<String> cache = new ArrayList<String>();
	public void writeCon(WechatMeta wechatMeta){
		final File conn = new File("record/"+wechatMeta.getUser().getString("UserName")+".json");
		//创建文件
		if(!conn.exists()){
			try {
				conn.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			
		}
			Writer writer;
			try {
				writer = new FileWriter(conn);
				 String line = System.getProperty("line.separator");
				 int count=0;
				 for (int i = 0, len = Constant.CONTACT.getMemberList().size(); i < len; i++) {
						JSONObject member = Constant.CONTACT.getMemberList().get(i).asJSONObject();
						// 公众号/服务号
						if (member.getInt("VerifyFlag", 0) == 24||member.getInt("VerifyFlag", 0) == 8) {
							continue;
						}
						// 特殊联系人
						if (Constant.FILTER_USERS.contains(member.getString("UserName"))) {
							continue;
						}
						// 群聊
						if (member.getString("UserName").indexOf("@@") != -1) {
							continue;
						}
						
						//写入UserName NickName RemarkName Signature
						writer.write(member.getString("RemarkName")+"   "+member.getString("NickName")+"  "+member.getString("UserName")+"\r\n");
						writer.write(line);
						writer.write(member.getString("Signature"));
						writer.flush();
						writer.write(line);
						count++;
					}
			System.out.println(count);	
			writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
}


