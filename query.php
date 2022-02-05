 <?php

require "conn.php";

$sql=$_POST["query"];

    $result=mysqli_query($conn, $sql);
    $arr=array();
    while($row = mysqli_fetch_array($result))
    {
        array_push($arr,$row);
    }

   echo json_encode($arr);
 mysqli_close($conn);
 ?> 