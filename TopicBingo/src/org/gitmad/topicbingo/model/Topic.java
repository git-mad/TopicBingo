package org.gitmad.topicbingo.model;

/**
 * Created by Alex on 2/24/14.
 */
public class Topic
{
    private String name;
    private boolean checked;

    public Topic(String name) {
        this.name = name;
        checked = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String toString() {
        return name;
    }
}
