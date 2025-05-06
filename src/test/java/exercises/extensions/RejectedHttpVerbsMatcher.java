package exercises.extensions;

import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.matching.MatchResult;
import com.github.tomakehurst.wiremock.matching.RequestMatcherExtension;

import java.util.List;

public class RejectedHttpVerbsMatcher extends RequestMatcherExtension {

    @Override
    public String getName() {
        return "rejected-verbs-matcher";
    }

    @Override
    public MatchResult match(Request request, Parameters parameters) {

        /**
         * Implement this custom matcher so that it:
         * - Reads the list of rejected verbs from the 'rejectedVerbs' parameter
         *   (use parameters.getList() to read the 'rejectedVerbs' parameter value
         *   into an object of type List<?>)
         * - Only return a positive match result when this list contains the
         *   HTTP method used in the incoming request
         *   You can retrieve this using request.getMethod().value()
         */
        List<?> rejectedVerbs = parameters.getList("rejectedVerbs");
//        if (rejectedVerbs.contains(request.getMethod().value())) {
//            return MatchResult.exactMatch();
//        }
//        else {
//            return MatchResult.noMatch();
//        }
        boolean isMatch = rejectedVerbs.contains(request.getMethod().value());
        return MatchResult.of(isMatch);
    }
}
