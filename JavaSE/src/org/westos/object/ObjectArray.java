package org.westos.object;
/**
 * ʲô�Ƕ�������?
 * 		���Դ洢���������
 * 
 * ����:��һ����,������5��ѧ��,�ֱ����Լ�����Ϣ(����,����,�Ա�...),����5��ѧ������Ϣ!
 * 	
 * 	����:
 * 		1)���붨��һ����: Student��
 * 		2)�ṩ��Ա:��Ա����/���췽��/��Ա����
 * 		3)�������鴴��:��������[] �������� = new ��������[���鳤��] ;
 * 		4)����5������ѧ������
 * 		5)ͨ��������ֵ
 * @author Administrator
 *
 */
//������
public class ObjectArray {
	
	public static void main(String[] args) {
		
		//����һ��ѧ������
		Student[] students = new Student[5] ;
		
		//����5��ѧ������
		Student s1 = new Student("���Ѿ�",29) ;
		Student s2 = new Student("�����",35) ;
		Student s3 = new Student("��ʩ",22) ;
		Student s4 = new Student("����",25) ;
		Student s5 = new Student("���밢ū��",28) ;
		
		//��ѧ������ֵ
		students[0] = s1 ;
		students[1] = s2 ;
		students[2] = s3 ;
		students[3] = s4 ;
		students[4] = s5 ;
		
		//length���� ѭ������
		for(int x = 0 ; x < students.length ; x ++) {
//			System.out.println(students[x]);
			
			//�Ľ�:��������get������ȡ����ѧ����Ϣ
			Student student = students[x] ;
			System.out.println(student.getName()+"----"+student.getAge());
		}
	}
}
