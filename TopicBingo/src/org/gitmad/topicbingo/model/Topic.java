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
        setChecked(false);
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString()
    {
        return name;
    }

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isTopic(String string) {
		if (this.name.compareToIgnoreCase(string)==0) {
			return true;
		}
		return false;
	}
}
