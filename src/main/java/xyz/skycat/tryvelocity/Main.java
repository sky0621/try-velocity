package xyz.skycat.tryvelocity;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class Main {

	public static void main(String[] args) {

		Velocity.init();

		doMainBean();
		doMain2Bean();
	}

	private static void doMainBean() {

		MainBean mb = new MainBean();
		mb.setMain("メイン！");
		SubBean sb = new SubBean();
		sb.setSub("サブ！");
		Sub2Bean sb2 = new Sub2Bean();
		sb2.setSub2("サブ２！");
		Sub3Bean sb3 = new Sub3Bean();
		sb3.setSub3("サブ３！");

		mb.setSubBean(sb);
		sb.setSub2Bean(sb2);
		sb2.setSub3Bean(sb3);

		VelocityContext context = new VelocityContext();
		context.put("bean", mb);
		Template template = Velocity.getTemplate(
				"src/main/resources/mail/template/main.vm", "UTF-8");
		StringWriter sw = new StringWriter();
		template.merge(context, sw);
		sw.flush();

		System.out.println(sw.toString());
		System.out.println("-------------------------------------");
	}

	private static void doMain2Bean() {

		Main2Bean mb2 = new Main2Bean();
		mb2.setMain2("メイン２！");
		Sub2Bean sb2 = new Sub2Bean();
		sb2.setSub2("サブ２！");
		Sub3Bean sb3 = new Sub3Bean();
		sb3.setSub3("サブ３！");

		mb2.setSub2Bean(sb2);
		sb2.setSub3Bean(sb3);

		VelocityContext context = new VelocityContext();
		context.put("bean", mb2);
		Template template = Velocity.getTemplate(
				"src/main/resources/mail/template/main2.vm", "UTF-8");
		StringWriter sw = new StringWriter();
		template.merge(context, sw);
		sw.flush();

		System.out.println(sw.toString());
		System.out.println("-------------------------------------");
	}

}
