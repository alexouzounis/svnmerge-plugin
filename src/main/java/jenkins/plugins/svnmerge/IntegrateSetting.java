package jenkins.plugins.svnmerge;

/**
 * @author Kohsuke Kawaguchi
 */
public class IntegrateSetting {	
	final String comment;
	final String issues;
	
	public IntegrateSetting() {
        this.comment="";
        this.issues="";
    }
	
	public IntegrateSetting(String comment, String issues) {
        this.comment=comment;
        this.issues=issues;
    }
}
