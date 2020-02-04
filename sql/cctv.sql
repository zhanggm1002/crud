-- 学历:1-专科，2-本科，3-研究生
-- 学位:1-学士，2-硕士，3-博士
SELECT a.`name`,IF(a.gender=1,'男','女') gender,a.birthday,a.college,a.major,edu,
			IF(a.edu=1,'专科',IF(a.edu=2,'本科','研究生')) eduName,
			IF(a.degree=1,'学士',IF(a.degree=2,'硕士','博士')) degreeName,sj.scoreDesc,sj.argScore,s.score zcScore
FROM cctv_applicant a
LEFT JOIN (SELECT s.aid,GROUP_CONCAT(j.`name`,s.score,'分') scoreDesc,ROUND(SUM(s.score)/COUNT(1)) argScore
					FROM cctv_score s
					LEFT JOIN cctv_job j ON s.jid=j.id
					GROUP BY s.aid) sj ON sj.aid=a.id
LEFT JOIN cctv_score s ON s.jid=1 AND a.id=s.aid
WHERE s.score>90 AND sj.argScore>60 AND a.edu=3


SELECT * FROM (
		SELECT a.`name`,IF(a.gender=1,'男','女') gender,a.birthday,a.college,a.major,edu,
					IF(a.edu=1,'专科',IF(a.edu=2,'本科','研究生')) eduName,
					IF(a.degree=1,'学士',IF(a.degree=2,'硕士','博士')) degreeName,sj.scoreDesc,sj.argScore,s.score zcScore
		FROM cctv_applicant a
		LEFT JOIN (SELECT s.aid,GROUP_CONCAT(j.`name`,s.score,'分') scoreDesc,ROUND(SUM(s.score)/COUNT(1)) argScore
							FROM cctv_score s
							LEFT JOIN cctv_job j ON s.jid=j.id
							GROUP BY s.aid) sj ON sj.aid=a.id
		LEFT JOIN cctv_score s ON s.jid=1 AND a.id=s.aid) ajs
WHERE zcScore>90 AND argScore>60 AND edu=3


SELECT s.aid,GROUP_CONCAT(j.`name`,s.score,'分') scoreDesc,ROUND(SUM(s.score)/COUNT(1)) argScore
FROM cctv_score s
LEFT JOIN cctv_job j ON s.jid=j.id
GROUP BY s.aid