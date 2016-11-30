package com.yfairy.jms.provider.service;

public interface IJmsSender {

	<T> void send(T object, String type);

	<T> void send(T object);

}