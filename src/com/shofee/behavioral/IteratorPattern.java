package com.shofee.behavioral;

import java.util.Objects;

class Notification {
    String notification;

    public Notification(String notification) {
        this.notification = notification;
    }

    public String getNotification() {
        return notification;
    }
}

interface Collection {
    Iterator createIterator();
}

class NotificationCollection implements Collection{
    int MAX_LEN = 10;
    int numberOfElements = 0;
    Notification[] notificationsList;

    public NotificationCollection() {
        notificationsList = new Notification[MAX_LEN];

        addItem("Notification 1");
        addItem("Notification 2");
        addItem("Notification 3");
    }

    void addItem(String val) {
        Notification notification = new Notification(val);

        if(numberOfElements >= MAX_LEN)
            System.err.println("List is Full");
        else {
            notificationsList[numberOfElements] = notification;
            numberOfElements++;
        }
    }

    @Override
    public Iterator createIterator() {
        return new NotificationIterator(notificationsList);
    }
}

interface Iterator {
    boolean hasNext();
    Object next();
}

class NotificationIterator implements Iterator {
    Notification[] notificationsList;
    int pos = 0;

    public NotificationIterator(Notification[] notificationsList) {
        this.notificationsList = notificationsList;
    }

    public boolean hasNext() {
        return !(pos >= notificationsList.length || notificationsList[pos] == null);
    }

    public Object next() {
        return notificationsList[pos++];
    }
}

class NotificationsBar {
    NotificationCollection notificationCollection;

    public NotificationsBar(NotificationCollection notificationCollection) {
        this.notificationCollection = notificationCollection;
    }

    public void printNotifications() {
        Iterator iterator = notificationCollection.createIterator();

        while (iterator.hasNext()) {
            Notification notification = (Notification)iterator.next();
            System.out.println(notification.getNotification());
        }
    }
}
public class IteratorPattern {
    public static void main(String args[]) {
        NotificationCollection notificationCollection = new NotificationCollection();
        NotificationsBar notificationsBar = new NotificationsBar(notificationCollection);
        notificationCollection.addItem("Notification 4");
        notificationsBar.printNotifications();
    }
}
