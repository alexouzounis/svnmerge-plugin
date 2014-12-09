package jenkins.plugins.svnmerge;

import hudson.model.PermalinkProjectAction.Permalink;

/**
 * @author Kohsuke Kawaguchi
 */
public class RebaseSetting {
    /**
     * Revision to rebase with. -1 to rebase to the latest;
     */
    public final long revision;
    public final String comment;
    public final String issues;
    /**
     * Permalink ID of the upstream to rebase to.
     * If this value is non-null, it takes precedence over {@link #revision}
     */
    public final String permalink;
    
    public RebaseSetting(long revision, String comment, String issues) {
        this.revision = revision;
        this.permalink = null;
        this.comment=comment;
        this.issues=issues;
    }

    public RebaseSetting(String permalink,String comment, String issues) {
        this.revision = -1;
        this.permalink = permalink;
        this.comment=comment;
        this.issues=issues;
    }

    public RebaseSetting(Permalink p,String comment, String issues) {
        this(p.getId(),comment,issues);
    }
}
