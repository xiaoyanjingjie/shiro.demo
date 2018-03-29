package com.sojson.gorgeousturn.controller.observer;

import java.util.Enumeration;
import java.util.Vector;
/**
 * 包括这个模式在内的接下来的四个模式，都是类和类之间的关系，不涉及到继承，学的时候应该 记得归纳，记得本文最开始的那个图。观察者模式很好理解，
 * 类似于邮件订阅和RSS订阅，当我们浏览一些博客或wiki时，经常会看到RSS图标，就这的意思是，
 * 当你订阅了该文章，如果后续有更新，会及时通知你。其实，简单来讲就一句话：当一个对象变化时，其它依赖该对象的对象都会收到通知，
 * 并且随着变化！对象之间是一种一对多的关系。先来看看关系图：。
 * 我解释下这些类的作用：MySubject类就是我们的主对象，Observer1和Observer2是依赖于MySubject的对象，当MySubject变化时，Observer1和Observer2必然变化。
 * AbstractSubject类中定义着需要监控的对象列表，可以对其进行修改：增加或删除被监控对象，且当MySubject变化时，负责通知在列表内存在的对象。我们看实现代码
 * 
 * */
public abstract class AbstractSubject implements Subject{
	/**
	 * ArrayList会比Vector快，他是非同步的，如果设计涉及到多线程，还是用Vector比较好一些 
       import java.util.*;
	 * */
	private Vector<Observer> vector = new Vector<Observer>();  
	@Override  
    public void add(Observer observer) {  
        vector.add(observer);  
    }  
  
    @Override  
    public void del(Observer observer) {  
        vector.remove(observer);  
    }  
  
    @Override  
    public void notifyObservers() {  
    	/**
    	 * 一.初识Enumeration
                                            当我写网络编程的时候，我发现了这个接口。很神奇的是以前都没用过，NetworkInterface.getNetworkInterfaces（ ）
                                             返回的是Enumeration载体这NetworkInterface对象。Enumeration是java.util中的一个接口类，在Enumeration中封装了有关枚举数据集合的方法。 
               Enumeration接口本身不是一个数据结构。但是，对其他数据结构非常重要。 Enumeration接口定义了从一个数据结构得到连续数据的手段。
				   注意：此接口的功能与 Iterator 接口的功能是重复的。此外，Iterator 接口添加了一个可选的移除操作，并使用较短的方法名。新的实现应该优先考虑使用 Iterato
				     接口而不是 Enumeration 接口。
				*/
        Enumeration<Observer> enumo = vector.elements();  
        while(enumo.hasMoreElements()){  
            enumo.nextElement().update();  
        }  
    }
    
  

}
