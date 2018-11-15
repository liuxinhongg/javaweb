<%@tag pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="action" type="java.lang.String" required="false" %>
<%@attribute name="query" type="java.lang.String" required="false" %>

<c:if test="${empty action}">
	<c:set var="action" value="${noQueryStringCurrentURL}"></c:set>
</c:if>

<c:if test="${pagination != null}">
	<div id="pagination ">
		<c:if test="${pagination.paging != null}">
			<ul class="bootpag pagination pagination-sm">
				<c:choose>
					<c:when test="${pagination.paging.rowCount <= 0}">
						<%-- <li>从 0 到 0 共 ${pagination.paging.rowCount } /条记录</li> --%>
						<li>抱歉，暂无数据</li>
					</c:when>
					<c:when test="${pagination.paging.rowCount < pagination.paging.endPosition}">
						<li>从 ${pagination.paging.startPosition + 1} 到 ${pagination.paging.rowCount } /共 ${pagination.paging.rowCount } 条记录</li>
					</c:when>
					<c:otherwise>
						<li>从 ${pagination.paging.startPosition + 1} 到 ${pagination.paging.endPosition } /共 ${pagination.paging.rowCount } 条记录</li>
					</c:otherwise>
					
				</c:choose>
			</ul>
			<input type="hidden" id="lastPage" value="${pagination.paging.lastPage }"/>
			<c:if test="${!empty pagination.data}">
				<ul class="bootpag pagination pagination-sm form-inline" style="float: right;">
					<!-- first page -->	
					<c:choose>
						<c:when test="${pagination.paging.hasPreviousPage}">
							<li data-lp="1" class="prev">
								<a href="${action }?${query}&pageNo=1"><icon class="fa fa-angle-double-left"></icon></a>
							</li>
							<li data-lp="1" class="prev">
								<a href="${action }?${query}&pageNo=${pagination.paging.currentPage-1}"><icon class="fa fa-angle-left"></icon></a>
							</li>
						</c:when>
						<c:otherwise>
							<li data-lp="1" class="prev disabled">
								<a href="javascript:void(0);"><icon class="fa fa-angle-double-left"></icon></a>
							</li>
							<li data-lp="1" class="prev disabled">
								<a href="javascript:void(0);"><icon class="fa fa-angle-left"></icon></a>
							</li>
						</c:otherwise>
					</c:choose>
					
					<c:set var="_count" value="5"></c:set>
					<c:choose>
						<c:when test="${pagination.paging.currentPage + 1 > _count}">
							<c:forEach begin="1" end="${_count-1}">
								<c:if test="${_count>0}">
									<c:set var="_cur" value="${pagination.paging.currentPage + 1 - _count}"></c:set>
									<li data-lp="${_cur}">
										<a href="${action}?${query}&pageNo=${_cur}">${_cur}</a>
									</li>
									<c:set var="_count" value="${_count - 1}"></c:set>
								</c:if>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:if test="${pagination.paging.currentPage > 1}">
								<c:forEach begin="1" end="${pagination.paging.currentPage - 1}" varStatus="status">
									<li data-lp="${status.count}">
										<a href="${action}?${query}&pageNo=${status.count}">${status.count}</a>
									</li>
								</c:forEach>
							</c:if>
						</c:otherwise>
					</c:choose>
					
					<!-- current pagepage -->
					<li data-lp="${pagination.paging.currentPage}" class="disabled"><a href="javascript:void(0);">${pagination.paging.currentPage}</a></li>
					
					<c:set var="_count" value="5"></c:set>
					<c:set var="_break" value="0"></c:set>
					<c:forEach begin="1" end="${_count-1}" varStatus="status">
						<c:if test="${_break == '0'}">
							<c:set var="_cur" value="${pagination.paging.currentPage+status.count}"></c:set>
							<c:choose>
								<c:when test="${_cur > pagination.paging.totalPage}">
									<c:set var="_break" value="1"></c:set>
								</c:when>
								<c:otherwise>
									<li data-lp="${_cur}"><a href="${action}?${query}&pageNo=${_cur}">${_cur}</a></li>
								</c:otherwise>
							</c:choose>
						</c:if>
					</c:forEach>
			
					<!-- last page -->
					<c:choose>
						<c:when test="${pagination.paging.currentPage < pagination.paging.totalPage}">
							<li data-lp="${pagination.paging.totalPage}" class="next">
								<a href="${action}?${query}&pageNo=${pagination.paging.currentPage+1}"><icon class="fa fa-angle-right"></icon></a>
							</li>
							<li data-lp="${pagination.paging.totalPage}" class="next">
								<a href="${action}?${query}&pageNo=${pagination.paging.totalPage}"><icon class="fa fa-angle-double-right"></icon></a>
							</li>
						</c:when>
						<c:otherwise>
							<li data-lp="7" class="next disabled">
								<a href="javascript:void(0);"><icon class="fa fa-angle-right"></icon></a>
							</li>
							<li data-lp="7" class="next disabled">
								<a href="javascript:void(0);"><icon class="fa fa-angle-double-right"></icon></a>
							</li>
						</c:otherwise>
					</c:choose>
					 <li>
						<%-- <select name="gopage" style="margin-top:3px;" onchange="location.href='${action}?${query}&pageNo='+this.value">
							<c:forEach begin="1" end="${pagination.paging.totalPage}" varStatus="status">
								<option value="${status.count}" ${pagination.paging.currentPage == status.count ? "selected='selected'":""}>${status.count}</option>
							</c:forEach>
						</select> --%>
						<input type="hidden" id="currentPage" value="${pagination.paging.currentPage }">
						<input class="gopage form-control" maxlength="8" style="padding:5px 3px;height:30px;width:50px;margin-left: -1px;" value="${pagination.paging.currentPage }">
						<i class="go btn" style="padding:5px 8px;height:30px;" onclick="location.href='${action}?${query}&pageNo='+getPageSize($('.gopage').val())">go</i>
					</li> 
				</ul>
			</c:if>
		</c:if>
	</div>
</c:if>