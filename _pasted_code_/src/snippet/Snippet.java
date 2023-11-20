package snippet;

public class Snippet {
	   <select id="qnaTotalCount" resultType="int">
	    SELECT COUNT (*)
	     FROM QNA_T
	   </select>    
	
	  <select id="getAllQnalist" resultMap="QnaMap">
	    SELECT QN.QNA_NO, QN.TITLE, QN.CONTENTS, QN.CREATED_AT, USR.USER_NO, USR.EMAIL, USR.NAME, QN.CHECK_FLAG
	      FROM QNA_T QN LEFT OUTER JOIN USER_T USR
	        ON QN.USER_NO = USR.USER_NO
	  </select>
	
	  <select id="getQnaCount" parameterType="int">
	    SELECT COUNT(CHECK_FLAG)
	     FROM QNA_T
	    <if test="checkFlag != 0">
	      WHERE CHECK_FLAG= #{checkFlag}
	    </if>
	  </select>
}

