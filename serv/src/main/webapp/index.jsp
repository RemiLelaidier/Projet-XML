<html>
<body>
    <style>

        td{
            border: 1px solid black;
            padding: 10px;
        }
    </style>
    <h1>API XML Projet Miage 2017</h1>
    <h2>List des routes</h2>
    <table>
        <thead>
            <td><b>Méthode</b></td>
            <td><b>Nom de la route</b></td>
            <td><b>Retour de la route</b></td>
        </thead>
        <tr>
            <td>GET</td>
            <td><a href="api/centers/list">/centers/list</a></td>
            <td>La liste des centres de recherches de l'INRIA avec pour chaque centre :<ul><li>Nom du centre</li><li>La localisation du centre(longitude , latitude)</li><li>Nombre d'équipes actives dans le centre</li><li>Nombre d'équipes fermées dans le centre</li><li>Nombre de personnes par centre</li></ul></td>
        </tr>
        <tr>
            <td>GET</td>
            <td><a href="api/centers/1">/centers/{id} id = 1</a></td>
            <td>Les informations d'un centre désigné par son id : <ul><li>Nom du centre</li><li>Nombre de personnes dans le centre</li><li>Nombre d'équipes actives dans le centre</li><li>Nombre d'équipes fermées dans le centre</li></ul></td>
        </tr>
    </table>
</body>
</html>
