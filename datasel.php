<?php
        $op = $_POST["op"];
        if($op == "uploadEmps"){
            $emplist = $_POST["emplist"];
            $cmd = "java -classpath /var/www/cgi-bin/:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar emp.Server $op $emplist";
        } else {
            $skill = $_POST["skill"];
            $day = $_POST["day"];
            $hour = $_POST["hour"];
            $cmd = "java -classpath /var/www/cgi-bin/:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar emp.Server $op $skill $day $hour";
}
	$str = shell_exec($cmd);
        print($str);
?>
