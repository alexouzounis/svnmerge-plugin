package jenkins.plugins.svnmerge;

import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.Job;
import hudson.model.PermalinkProjectAction;
import hudson.model.Run;

import java.util.Collections;
import java.util.List;

/**
 * Project-level {@link Action} that shows the integration status on a feature branch job.
 *
 * <p>
 * This also adds a permalink to {@link AbstractProject}.
 *
 * @author Kohsuke Kawaguchi
 */
public class RebaseStatusAction implements PermalinkProjectAction {
    public final AbstractProject<?,?> project;
    public final FeatureBranchProperty branchProperty;

    public RebaseStatusAction(FeatureBranchProperty fbp) {
        this.project = fbp.getOwner();
        this.branchProperty = fbp;
    }

    /**
     * Finds the last build that got rebased from the upstream, or else null.
     */
    public AbstractBuild<?,?> getLastRebasedBuild() {
        RebaseAction ra = getLastRebaseAction(project);
        return ra!=null ? ra.build : null;
    }

    public RebaseAction getLastRebaseAction() {
        return getLastRebaseAction(project);
    }

    static RebaseAction getLastRebaseAction(Job<?,?> j) {
        for(Run<?,?> b=j.getLastBuild(); b!=null; b=b.getPreviousBuild()) {
            RebaseAction ra = b.getAction(RebaseAction.class);
            if(ra!=null && ra.isRebased())
                return ra;
        }
        return null;
    }

    public List<Permalink> getPermalinks() {
        return PERMALINKS;
    }

    public String getIconFileName() {
        return "/plugin/svnmerge/24x24/sync.gif";
    }

    public String getDisplayName() {
        return "Rebase Status";
    }

    public String getUrlName() {
        return "rebase-status";
    }

    private static final List<Permalink> PERMALINKS = Collections.<Permalink>singletonList(new Permalink() {
        public String getDisplayName() {
            return "Last Rebased build";
        }

        @Override
        public String getId() {
            return "lastRebasedBuild";
        }

        @Override
        public Run<?,?> resolve(Job<?,?> job) {
            RebaseAction ra = getLastRebaseAction(job);
            return ra!=null ? ra.build : null;
        }
    });
}
