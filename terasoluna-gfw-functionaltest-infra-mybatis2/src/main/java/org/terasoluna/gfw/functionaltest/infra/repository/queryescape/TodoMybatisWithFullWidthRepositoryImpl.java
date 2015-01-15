package org.terasoluna.gfw.functionaltest.infra.repository.queryescape;

import java.util.List;

import javax.inject.Inject;

import jp.terasoluna.fw.dao.QueryDAO;

import org.springframework.stereotype.Repository;
import org.terasoluna.gfw.common.query.QueryEscapeUtils;
import org.terasoluna.gfw.functionaltest.domain.model.Todo;
import org.terasoluna.gfw.functionaltest.domain.repository.queryescape.TodoMybatisWithFullWidthRepository;

@Repository
public class TodoMybatisWithFullWidthRepositoryImpl implements
        TodoMybatisWithFullWidthRepository {

    @Inject
    protected QueryDAO queryDAO;
    
    @Override
    public List<Todo> findAllByTitleLikePrefix(String title) {
        String todoTitle = QueryEscapeUtils.withFullWidth().toStartingWithCondition(title);
        return queryDAO.executeForObjectList("queryescape.findAllByTitleLike", todoTitle);
    }

    @Override
    public List<Todo> findAllByTitleLikeSuffix(String title) {
        String todoTitle = QueryEscapeUtils.withFullWidth().toEndingWithCondition(title);
        return queryDAO.executeForObjectList("queryescape.findAllByTitleLike", todoTitle);
    }

    @Override
    public List<Todo> findAllByTitleLikePartical(String title) {
        String todoTitle = QueryEscapeUtils.withFullWidth().toContainingCondition(title);
        return queryDAO.executeForObjectList("queryescape.findAllByTitleLike", todoTitle);
    }

}
