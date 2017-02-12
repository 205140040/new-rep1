package com.yfairy.demo.effective_java;

public class StaticFactory {

	public static void main(String[] args) {
		/**
		 * 第1条考虑用静态工厂方法代替构造器<br>
		 * 优点:静态工厂方法可以自定义名称，比构造器声明的更容易理解意思，<br>
		 * 2.静态工厂方法，可以返回该类的子类，但是构造器不能<br>
		 * getInstance 单例模式返回单个实例工厂方法.<br>
		 * newInstance 返回new 实例的工厂方法<br>
		 * getType 返回单个类型的工厂方法<br>
		 * newType new 类型的工厂方法<br>
		 */
		Student s1 = Student.newInstance();
		System.out.println(s1);
		Student s2 = Student.newInstanceWithNameAndAge("zhangsan", 18);
		System.out.println(s2);
		Student s3 = Student.newStudentType();
		System.out.println(s3);

	}

	static class Student {

		private String name;

		private Integer age;

		private Integer score;

		public static Student newInstance() {
			return new Student();
		}

		/**
		 * 静态工厂方法，返回类型的子类
		 * 
		 * @return
		 */
		public static Student newStudentType() {
			return new StudentCard();
		}

		/**
		 * 静态工厂方法，名称更容易理解
		 * 
		 * @param name
		 * @param age
		 * @return
		 */
		public static Student newInstanceWithNameAndAge(String name, Integer age) {
			Student student = new Student();
			student.setName(name);
			student.setAge(age);
			return student;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public Integer getScore() {
			return score;
		}

		public void setScore(Integer score) {
			this.score = score;
		}

	}

	static class StudentCard extends Student {
		private String card;

		public String getCard() {
			return card;
		}

		public void setCard(String card) {
			this.card = card;
		}

		@Override
		public String toString() {
			return "StudentCard [card=" + card + "]";
		}

	}

}
