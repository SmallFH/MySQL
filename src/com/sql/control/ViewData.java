package com.sql.control;

import java.util.ArrayList;

import com.sql.model.DataMap;

public class ViewData {
	static DataMap dataMap = new DataMap();
	
	public static DataMap enterView() {
		dataMap.setJf_name("��¼");
		dataMap.setJf_size(new int[] {400, 400 });
		dataMap.setJb_name(new String[] { "��¼", "ע��" });
		dataMap.setJb_parameter(new int[] { 2, 100, 170, 70, 40 });
		dataMap.setJl_name(new String[] { "�û�����", "��     �룺"});
		dataMap.setJl_parameter(new int[] { 2, 100, 85, 80, 30 });
		dataMap.setJtf_parameter(new int[] { 1, 160, 85, 150, 30 });
		dataMap.setJpf_parameter(new int[] { 1, 160, 115, 150, 30 });
		dataMap.setJcb_name(new String[] { "ѧ��", "��ʦ", "����Ա" });
		dataMap.setJcb_parameter(new int[] { 3, 240, 170, 70, 40 });
		return dataMap;
	}
	
	public static DataMap StudentPanel() {
		dataMap.setJl_name(new String[] {"�꼶��","�Ա�","Ժϵ��",
				"רҵ��","�༶��","ѧ�ţ�","������","���գ�",
				"�绰��","�ܱ����⣺","�ܱ��𰸣�","���룺","ȷ�����룺"});
		dataMap.setJl_parameter(new int[] { 13,50,50,70,40 });
		dataMap.setJcb_name(new String[] { "��һ", "���", "����" ,"����"});
		dataMap.setJcb_parameter(new int[] { 4, 110, 55, 60, 30 });
		dataMap.setJrb_parameter(new int[] {2,105,90,40,40});
		dataMap.setJrb_name(new String[] {"��","Ů"});
		dataMap.setJtf_parameter(new int[] { 9,110,135,150,30 });
		dataMap.setJpf_parameter(new int[] { 2,110,495,150,30 });
		dataMap.setJf_name("ע��");
		dataMap.setJf_size(new int[] { 1000, 700 });
		return dataMap;
	}
	
	public static DataMap TeacherPanel() {
		dataMap.setJl_name(new String[] {"�Ա�","Ժϵ��","רҵ��","ְ���ţ�",
				"���ڿ�Ŀ��","������","���գ�","�绰��","�ܱ����⣺",
				"�ܱ��𰸣�","���룺","ȷ�����룺"});
		dataMap.setJl_parameter(new int[] { 12,50,50,70,40 });
		dataMap.setJrb_name(new String[] {"��","Ů"});
		dataMap.setJrb_parameter(new int[] {2,105,50,40,40});
		dataMap.setJtf_parameter(new int[] { 9,110,95,150,30 });
		dataMap.setJpf_parameter(new int[] { 2,110,455,150,30 });
		dataMap.setJf_name("ע��");
		dataMap.setJf_size(new int[] { 1000, 700 });
		return dataMap;
	}
	
	public static DataMap RegisterView() {
		dataMap.setJf_name("ע��");
		dataMap.setJf_size(new int[] {1000, 700 });
		dataMap.setJb_name(new String[] { "�ύ", "�˳�" });
		dataMap.setJb_parameter(new int[] { 2, 100, 170, 70, 40 });
		dataMap.setJrb_parameter(new int[] {2,100,100,40,40});
		dataMap.setJrb_name(new String[] {"ѧ��","��ʦ"});
		return dataMap;
	}
	
	public static DataMap StuView() {
		String[] jmu = { "������Ϣ", "�γ���Ϣ", "�ɼ���Ϣ", "������Ϣ"};
		String[] jmi1 = {"�鿴������Ϣ"};
		String[] jmi2 = { "�鿴�༶�γ�", "��ѡ�γ�", "�鿴��ѡ�γ̻��˿�"};
		String[] jmi3 = {"�鿴�ɼ�"};
		String[] jmi4 = {"�޸�����"};
		ArrayList<String[]> arrayList = new ArrayList<>();
		arrayList.add(jmu);
		arrayList.add(jmi1);
		arrayList.add(jmi2);
		arrayList.add(jmi3);
		arrayList.add(jmi4);
		dataMap.setJf_name("ѧ����");
		dataMap.setJf_size(new int[] {1000, 700 });
		dataMap.setArrayList(arrayList);
		return dataMap;
	}
	public static DataMap ChoosePanel() {
		dataMap.setJf_name("ѡ��");
		dataMap.setJf_size(new int[] {1000, 700 });
		dataMap.setJl_name(new String[] { "�γ̱�ţ�"});
		dataMap.setJl_parameter(new int[] { 1, 250, 10, 80, 30 });
		dataMap.setJtf_parameter(new int[] { 1,350,10,150,30 });
		dataMap.setJb_name(new String[]{"ѡ��"});
		dataMap.setJb_parameter(new int[] {1,550,10,100,30});
		return dataMap;
		
	}
	
	public static DataMap TeachView() {
		String[] jmu = { "������Ϣ", "�ɼ���Ϣ", "�Ͽ�ʱ��",  "�������"};
		String[] jmi1 = {"�鿴������Ϣ"};
		String[] jmi2 = { "�鿴�����༶ѧ���ɼ���Ϣ", "¼�������༶ѧ���ɼ�"};
		String[] jmi3 = {"�鿴�γ�"};
		String[] jmi4 = {"�޸�����"};
		ArrayList<String[]> arrayList = new ArrayList<>();
		arrayList.add(jmu);
		arrayList.add(jmi1);
		arrayList.add(jmi2);
		arrayList.add(jmi3);
		arrayList.add(jmi4);
		dataMap.setJf_name("��ʦ��");
		dataMap.setJf_size(new int[] {1000, 700 });
		dataMap.setArrayList(arrayList);
		return dataMap;
	}
	
	public static DataMap AddGradePanel() {
		dataMap.setJf_name("��ʦ��");
		dataMap.setJf_size(new int[] {1000, 700 });
		dataMap.setJl_name(new String[] { "ѧ�ţ�","�ɼ���"});
		dataMap.setJl_parameter(new int[] { 2, 250, 10, 80, 30 });
		dataMap.setJb_name(new String[]{"¼��"});
		dataMap.setJb_parameter(new int[] {1,550,10,100,30});
		dataMap.setJtf_parameter(new int[] { 2,110,135,150,30 });
		return dataMap;
	}
	
	public static DataMap ChangePass() {
		dataMap.setJf_name("�޸�����");
		dataMap.setJf_size(new int[] {1000, 700 });
		dataMap.setJl_name(new String[] { "�ܱ����⣺","�ܱ��𰸣�","�����룺","ȷ�������룺"});
		dataMap.setJl_parameter(new int[] { 4, 250, 10, 80, 30 });
		dataMap.setJb_name(new String[]{"�޸�", "�����ܱ��𰸣�"});
		dataMap.setJb_parameter(new int[] {2,550,10,100,30});
		dataMap.setJtf_parameter(new int[] { 1,110,135,150,30 });
		dataMap.setJpf_parameter(new int[] { 2,110,170,150,30 });
		return dataMap;
	}
	
	
	
	public static DataMap RestPassWord() {
		dataMap.setJf_name("��������");
		dataMap.setJf_size(new int[] {1000, 700 });
		dataMap.setJl_name(new String[] { "���������˺ţ�","����Ա���룺","�û���ݣ�"});
		dataMap.setJl_parameter(new int[] { 3, 250, 10, 80, 30 });
		dataMap.setJb_name(new String[]{"����"});
		dataMap.setJb_parameter(new int[] {1,550,10,100,30});
		dataMap.setJtf_parameter(new int[] { 1,110,135,150,30 });
		dataMap.setJpf_parameter(new int[] { 1,110,170,150,30 });
		dataMap.setJcb_name(new String[] { "ѧ��", "��ʦ" });
		dataMap.setJcb_parameter(new int[] { 2, 240, 170, 70, 40 });
		return dataMap;
	}
	
	public static DataMap AdminView() {
		String[] jmu = { "ѧ��������Ϣ����", "��ʦ������Ϣ����", "ѧ���ɼ���Ϣ����", "�γ���Ϣ����", "������Ϣ����"};
		String[] jmi1 = {"ѧ��������Ϣ"};
		String[] jmi2 = { "��ʦ������Ϣ"};
		String[] jmi3 = {"�ɼ���Ϣ"};
		String[] jmi4 = {"�γ���Ϣ"};
		String[] jmi5 = {"�޸Ĺ���Ա����","�����û�����"};
		ArrayList<String[]> arrayList = new ArrayList<>();
		arrayList.add(jmu);
		arrayList.add(jmi1);
		arrayList.add(jmi2);
		arrayList.add(jmi3);
		arrayList.add(jmi4);
		arrayList.add(jmi5);
		dataMap.setJf_name("����Ա��");
		dataMap.setJf_size(new int[] {1000, 700 });
		dataMap.setArrayList(arrayList);
		return dataMap;
		
	}
	
	public static DataMap AdminInfoPanel() {
		dataMap.setJf_name("�����Ϣ");
		dataMap.setJf_size(new int[] {1000, 700 });
		dataMap.setJtf_parameter(new int[] { 1,110,10,150,30 });
		dataMap.setJb_name(new String[]{"��ѯ","���","�޸�","ɾ��"});
		dataMap.setJb_parameter(new int[] {4,550,10,100,30});
		return dataMap;
	}
	
	public static DataMap ChangeSecurityIssue() {
		dataMap.setJf_name("�����ܱ�");
		dataMap.setJf_size(new int[] {1000, 700 });
		dataMap.setJl_name(new String[] { "���ܱ����⣺","���ܱ��𰸣�"});
		dataMap.setJl_parameter(new int[] { 2, 250, 10, 80, 30 });
		dataMap.setJtf_parameter(new int[] { 2,110,10,150,30 });
		dataMap.setJb_name(new String[]{"�ύ" ,"�˳��޸�"});
		dataMap.setJb_parameter(new int[] {2,550,10,100,30});
		return dataMap;
	}
	
}
