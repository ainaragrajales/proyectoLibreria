for $libro in /ListaLibrosLibreria/DatosLibro
order by $libro/titulo
return
if ($libro/genero='romance')
then
<ROMANCE>{$libro/titulo/text()}
</ROMANCE>
else if ($libro/OFICIO='urban fantasy')
then
<URBAN_FANTASY>{data($libro/titulo)}
</URBAN_FANTASY>
else
<OTROS>{data($libro/titulo)}
</OTROS>