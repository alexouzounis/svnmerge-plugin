package jenkins.plugins.svnmerge;

/**
 * @author Kohsuke Kawaguchi
 */
public class IntegrateSetting {	
	String comment;
	String issues;
	
	public IntegrateSetting(String comment, String issues) {
        this.comment=comment;
        this.issues=issues;
    }
}
