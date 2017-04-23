package com.yfairy.mbgenerator.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.DefaultCommentGenerator;

public class CommentGeneratorImpl extends DefaultCommentGenerator {

	private boolean suppressDate;
	private boolean suppressAllComments;

	private static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public CommentGeneratorImpl() {
		super();
		suppressDate = false;
		suppressAllComments = false;
	}

	@Override
	public void addComment(XmlElement xmlElement) {

	}

	@Override
	protected String getDateString() {
		if (suppressDate) {
			return null;
		} else {
			return sdf.format(new Date());
		}
	}

	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		innerClass.addJavaDocLine("/**"); //$NON-NLS-1$

		sb.append(" * "); //$NON-NLS-1$
		sb.append(introspectedTable.getFullyQualifiedTable());
		innerClass.addJavaDocLine(sb.toString());

		addJavadocTag(innerClass, false);

		innerClass.addJavaDocLine(" */"); //$NON-NLS-1$
	}

	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		field.addJavaDocLine("/**"); //$NON-NLS-1$

		sb.append(" * "); //$NON-NLS-1$

		sb.append(introspectedColumn.getActualColumnName());
		sb.append(" ");
		sb.append(introspectedColumn.getRemarks());
		field.addJavaDocLine(sb.toString());

		// addJavadocTag(field, false);

		field.addJavaDocLine(" */"); //$NON-NLS-1$
	}

	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		field.addJavaDocLine("/**"); //$NON-NLS-1$

		sb.append(" * "); //$NON-NLS-1$
		sb.append(introspectedTable.getFullyQualifiedTable());
		field.addJavaDocLine(sb.toString());

		addJavadocTag(field, false);

		field.addJavaDocLine(" */"); //$NON-NLS-1$
	}

	@Override
	public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}

	}

	public void addGetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		method.addJavaDocLine("/**"); //$NON-NLS-1$

		sb.append(" * "); //$NON-NLS-1$
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString());

		method.addJavaDocLine(" *"); //$NON-NLS-1$

		sb.setLength(0);
		sb.append(" * @return "); //$NON-NLS-1$
		sb.append(introspectedColumn.getActualColumnName());
		sb.append(" ");
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString());

		// addJavadocTag(method, false);

		method.addJavaDocLine(" */"); //$NON-NLS-1$
	}

	public void addSetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		method.addJavaDocLine("/**"); //$NON-NLS-1$

		sb.append(" * "); //$NON-NLS-1$
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString());

		method.addJavaDocLine(" *"); //$NON-NLS-1$

		Parameter parm = method.getParameters().get(0);
		sb.setLength(0);
		sb.append(" * @param "); //$NON-NLS-1$
		sb.append(parm.getName());
		sb.append(" ");
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString());

		// addJavadocTag(method, false);

		method.addJavaDocLine(" */"); //$NON-NLS-1$
	}

	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
		if (suppressAllComments) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		innerClass.addJavaDocLine("/**"); //$NON-NLS-1$

		sb.append(" * "); //$NON-NLS-1$
		sb.append(introspectedTable.getFullyQualifiedTable());
		innerClass.addJavaDocLine(sb.toString());

		sb.setLength(0);
		sb.append(" * @author ");
		sb.append(" ll ");
		sb.append(" ");
		sb.append(getDateString());

		// addJavadocTag(innerClass, markAsDoNotDelete);

		innerClass.addJavaDocLine(" */"); //$NON-NLS-1$
	}

}
